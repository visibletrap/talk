var f = function(coll, n) {
	var result = [];
	for (var i = 0; i < coll.length; i++) {
		if ((i+1) % 3 !== 0) {
			result.push(coll[i]);
		}
	}
	return result;
}
console.log(f([1,2,3,4,5,6,7,8],3));
