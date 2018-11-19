(ns rdd-talk.registered-cars
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io]
            [clojure.string :as string]))

(def car-types
  {:sedan-not-more-than-7-pass {:name-th "รถยนต์นั่งส่วนบุคคลไม่เกิน 7 คน"
                                :id "รย. 1"}
   :micro-bus-&-passenger-van {:name-th "รถยนต์นั่งส่วนบุคคลเกิน 7 คน"
                               :id "รย. 2"}
   :van-&-pickup {:name-th "รถยนต์บรรทุกส่วนบุคคล"
                  :id "รย. 3"}
   :motortricycle {:name-th "รถยนต์สามล้อส่วนบุคคล"
                   :id "รย. 4"}
   :interprovincial-taxi {:name-th "รถยนต์รับจ้างระหว่างจังหวัด"
                          :id "รย. 5"}
   :urban-taxi {:name-th "รถยนต์รับจ้างบรรทุกคนโดยสารไม่เกิน 7 คน"
                :id "รย. 6"}
   :fixed-route-taxi {:name-th "รถยนต์สี่ล้อเล็กรับจ้าง"
                      :id "รย. 7"}
   :motortricycle-taxi-aka-tuk-tuk {:name-th "รถยนต์รับจ้างสามล้อ"
                                    :id "รย. 8"}
   :hotel-taxi {:name-th "รถยนต์บริการธุรกิจ"
                :id "รย. 9"}
   :tour-taxi {:name-th "รถยนต์บริการทัศนาจร"
               :id "รย. 10"}
   :car-for-hire {:name-th "รถยนต์บริการให้เช่า"
                  :id "รย. 11"}
   :motorcycle {:name-th "รถจักรยานยนต์ส่วนบุคคล"
                :id "รย. 12"}
   :tractor {:name-th "รถแทรกเตอร์"
             :id "รย. 13"}
   :road-roller {:name-th "รถบดถนน"
                 :id "รย. 14"}
   :farm-vehicle {:name-th "รถใช้งานเกษตรกรรม"
                  :id "รย. 15"}
   :automobile-trailer {:name-th "รถพ่วง"
                        :id "รย. 16"}
   :public-motorcycle {:name-th "รถจักรยานยนต์สาธารณะ"
                       :id "รย. 17"}})

(def regions
  {:central {:en "Central"
             :th "ภาคกลาง"}
   :eastern {:en "Eastern"
             :th "ภาคตะวันออก"}
   :north-eastern {:en "North Eastern"
                   :th "ภาคตะวันออกเฉียงเหนือ"}
   :northern {:en "Northern"
              :th "ภาคเหนือ"}
   :western {:en "Western"
             :th "ภาคตะวันตก"}
   :southern {:en "Southern"
              :th "ภาคใต้"}})

(def region-name-th->region-id (reduce (fn [m [id {:keys [th]}]] (assoc m th id)) {} regions))

(defn resolve-regions [mixed-areas]
  (let [not-region? (complement #(string/starts-with? % "รวม"))
        [_ interested-areas] (split-with not-region? mixed-areas)]
    (loop [processed {}
           [region & unprocessed] interested-areas]
      (if region
        (let [[in-region unprocessed] (split-with not-region? unprocessed)]
          (recur (assoc processed (string/replace region #"รวม" "") (set in-region)) unprocessed))
        processed))))

(defn add-line [area-stats key-name line]
  (mapv (fn [as v] (assoc as key-name v)) area-stats line))

(def value-string->number (comp #(Long/parseLong %)
                                #(string/replace % #"-" "0")
                                #(string/replace % #"," "")))

(defn add-value-lines [area-stats line-descriptions lines]
  (reduce
    (fn [acc [key-name line-number]]
      (add-line acc key-name (map value-string->number (map string/trim (drop 1 (get lines line-number))))))
    area-stats
    line-descriptions))

(defn annotate [area-stats province->region-id]
  (map
    (fn [{:keys [area-name-th] :as area-stat}]
      (let [[type region] (cond
                            (= area-name-th "ทั่วประเทศ") [:aggregate :country]
                            (= area-name-th "กรุงเทพฯ") [:province :bangkok]
                            (= area-name-th "ส่วนภูมิภาค") [:aggregate :regional]
                            (string/starts-with? area-name-th "ภาค") [:aggregate (region-name-th->region-id area-name-th)]
                            :default [:province (province->region-id area-name-th)])]
        (assoc area-stat :type type :region region)))
    area-stats))

(defn area-stats []
  (let [lines (->> (with-open [reader (io/reader "registered-cars-201712.csv")]
                     (doall (csv/read-csv reader)))
                   (drop 3)
                   (into []))]
    (let [province->region-id (->> (first lines)
                                   (drop 1)
                                   (map string/trim)
                                   resolve-regions
                                   (reduce (fn [m [region provinces]]
                                             (reduce (fn [m2 province] (assoc m2 province region)) m provinces))
                                           {})
                                   (map (juxt first (comp region-name-th->region-id second)))
                                   (into {}))
          initial-maps (->> lines first (drop 1) (mapv (fn [_] {})))
          value-line-descriptions {:total 2
                                   :sedan-not-more-than-7-pass 6
                                   :micro-bus-&-passenger-van 7
                                   :van-&-pickup 8
                                   :motortricycle 9
                                   :interprovincial-taxi 10
                                   :urban-taxi 11
                                   :fixed-route-taxi 15
                                   :motortricycle-taxi-aka-tuk-tuk 16
                                   :hotel-taxi 17
                                   :tour-taxi 18
                                   :car-for-hire 19
                                   :motorcycle 20
                                   :tractor 21
                                   :road-roller 22
                                   :farm-vehicle 23
                                   :automobile-trailer 24
                                   :public-motorcycle 25}]
      (-> initial-maps
          (add-line :area-name-th (->> (get lines 0)
                                       (drop 1)
                                       (map string/trim)
                                       (map #(if (string/starts-with? % "รวม") (string/replace % #"รวม" "") %))))
          (annotate province->region-id)
          (add-line :area-name (map string/trim (drop 1 (get lines 1))))
          (add-value-lines value-line-descriptions lines)))))

(defn province-stats []
  (filterv (comp #{:province} :type) (area-stats)))

(comment
(first (province-stats))

(defn top-province-by-car-type
  [car-type]
  (->> (province-stats)
       (remove (comp #{"กรุงเทพฯ"} :area-name-th))
       (sort-by car-type >)
       first
       :area-name-th))

(top-province-by-car-type :farm-vehicle)
(top-province-by-car-type :tractor)
(top-province-by-car-type :van-&-pickup)
(top-province-by-car-type :motorcycle)

(map (juxt identity top-province-by-car-type) (keys car-types))
)
