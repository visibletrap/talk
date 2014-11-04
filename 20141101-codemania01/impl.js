function mapper1(coll, f) {
	var newColl = [];
	for (var i = 0; i < coll.length; i++) {
		newColl[i] = f(coll[i]);
	}
	return newColl;
}

var numbers = [1, 2, 3, 4, 5];
var increment = function(i) {
	return i + 1;
};
var incrementedNumbers1 = mapper1(numbers, increment);
console.log(incrementedNumbers1);

function mapper2(coll, f) {
	if (coll.length === 0) {
		return [];
	} else {
		return [f(coll[0])].concat(mapper2(coll.slice(1,coll.length),f));
	}
}

var incrementedNumbers2 = mapper2(numbers, increment);
console.log(incrementedNumbers2);
