var videos = [
	{
		id: 'BE8-8f6lxWo',
		publishedAt: '2014-10-01T22:45:24.000Z'
	},
	{
		id: 'aJjYLc1gjTE',
		publishedAt: '2014-09-06T02:35:12.000Z'
	}
]
var thisMonthVideos1 = [];
for (var i = 0; i < videos.length; i++) {
	if (videos[i].publishedAt > '2014-10-01T00:00:00.000Z') {
		thisMonthVideos1.push(videos[i]);
	}
}
console.log(thisMonthVideos1);

var thisMonthVideos2 = videos.filter(function(video) {
	return video.publishedAt > '2014-10-01T00:00:00.000Z';
});
console.log(thisMonthVideos2);
