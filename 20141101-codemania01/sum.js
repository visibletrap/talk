var videos = [
	{
		id: 'BE8-8f6lxWo',
		diffCount: 90
	},
	{
		id: 'aJjYLc1gjTE',
		diffCount: 250
	}
];
var sumDiff1 = 0;
for (var i = 0; i < videos.length; i++) {
	sumDiff1 += videos[i].diffCount;
}
console.log(sumDiff1);

var sumDiff2 = videos.reduce(function(result, video) {
	return result + video.diffCount;
}, 0);
console.log(sumDiff2);
