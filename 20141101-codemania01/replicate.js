var replicateSequence = function(seq, n) {
	var result = [];
	for (var i = 0; i < seq.length; i++) {
		for (var j = 0; j < n; j++) {
			result.push(seq[i]);
		}
	}
	return result;
}
console.log(replicateSequence([2,2,3], 2));
