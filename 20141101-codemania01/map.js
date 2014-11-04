var videos = [
	{
		id: 'BE8-8f6lxWo',
		likeCount: 100,
	   	dislikeCount: 10
	},
	{
		id: 'aJjYLc1gjTE',
		likeCount: 300,
		dislikeCount: 50
	}
];

var likeDiffVideos1 = [];
for (var i = 0; i < videos.length; i++) {
	videoWithDiff = {
		id: videos[i].id,
		likeCount: videos[i].likeCount,
		dislikeCount: videos[i].dislikeCount,
		diffCount: videos[i].likeCount - videos[i].dislikeCount
	};
	likeDiffVideos1.push(videoWithDiff);
}
console.log(likeDiffVideos1);

var likeDiffVideos2 = videos.map(function(video) {
	return {
		id: video.id,
		likeCount: video.likeCount,
		dislikeCount: video.dislikeCount,
		diffCount: video.likeCount - video.dislikeCount
	};
});
console.log(likeDiffVideos2);
