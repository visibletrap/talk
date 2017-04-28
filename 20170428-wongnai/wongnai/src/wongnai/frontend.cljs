(ns wongnai.frontend
  (:require [reagent.core :as r]))

(enable-console-print!)

(defonce app-state
  (r/atom {:items (vec (range 1 105))
           :page-number 1})) ; Important for keeping data between reloads

(defn pagination [page-number page-count]
  [:div.pagination
   (if (not= page-number 1)
     [:div.pointable {:on-click #(swap! app-state update :page-number dec)} "<"]
     [:div])
   [:div page-number]
   [:div "of"]
   [:div page-count]
   (if (not= page-number page-count)
     [:div.pointable {:on-click #(swap! app-state update :page-number inc)} ">︎︎"]
     [:div])])

(pagination 1 10)

(defn boxes [items]
  [:ul.boxes
   (for [i items]
     ^{:key i} [:li [:div.box i]])])

(defn root []
  (let [{:keys [items page-number]} @app-state
        item-pages (partition-all 4 items)]
    [:div
     [pagination 1 (count item-pages)]
     [boxes (nth item-pages (dec page-number))]]))

(defn mount [] (r/render [root] (.getElementById js/document "app")))
(defn start [] (mount))
(defn ^:export init [] (start))
