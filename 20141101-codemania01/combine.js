var videos = [
	{
		id: 'BE8-8f6lxWo',
		publishedAt: '2014-10-01T22:45:24.000Z',
		likeCount: 100,
	   	dislikeCount: 10
	},
	{
		id: 'aJjYLc1gjTE',
		publishedAt: '2014-09-06T02:35:12.000Z',
		likeCount: 300,
		dislikeCount: 50
	}
];

var sumDiff1 = 0;
for (var i = 0; i < videos.length; i++) {
	if (videos[i].publishedAt > '2014-10-01T00:00:00.000Z') {
	   sumDiff1 += videos[i].likeCount - videos[i].dislikeCount;
	}
}
console.log(sumDiff1);

var sumDiff2 = videos.filter(function(video) {
	return video.publishedAt > '2014-10-01T00:00:00.000Z';
}).map(function(video) {
	return { diffCount: video.likeCount - video.dislikeCount };
}).reduce(function(result, video) {
	return result + video.diffCount;
}, 0);
console.log(sumDiff2);

var fromLastMonth = function(video) { return video.publishedAt > '2014-10-01T00:00:00.000Z'; }
var calDiffCount = function(video) { return { diffCount: video.likeCount - video.dislikeCount }; }
var sumDiffCount = function(result, video) { return result + video.diffCount; }
var sumDiff3 = videos.filter(fromLastMonth).map(calDiffCount).reduce(sumDiffCount,0);
console.log(sumDiff3);
