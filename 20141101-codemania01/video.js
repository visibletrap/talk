//var videos = [
	//{
		//id: "a",
		//publishedAt: "2012-06-20T22:45:24.000Z",
		//viewCount: "35"
	//}
//];

var videos = [
	{
		id: "a",
		publishedAt: "2014-06-20T22:45:24.000Z",
		comments: [
			{
				content: "Cool",
				likeCount: "50"
			},
			{
				content: "Awesome",
				likeCount: "70"
			}
		]
	},
	{
		id: "b",
		publishedAt: "2012-06-20T22:45:24.000Z",
		comments: [ ]
	}
];

var thisYear = function(video) {
	return video.publishedAt > "2014-01-11T00:00:00.000Z";
};

var comments = function(video) {
	return video.comments;
};

var concat = function(result, current) {
	return result.concat(current);
}

var compareCount = function(a, b) {
	return b.likeCount - a.likeCount;
}

var content = function(comment) {
	return comment.content;
}

var out1 = videos.filter(thisYear).map(comments).reduce(concat).sort(compareCount).map(content);
console.log("===> out: ", out1);


var out2 = [];
var allComments = [];
for (var i = 0; i < videos.length; i++) {
	var video = videos[i];
	if (thisYear(video)) {
		allComments = allComments.concat(video.comments);
	}
}

allComments.sort(compareCount);
for (var i = 0; i < allComments; i++) {
	out2.push(allComments[i].content);
}
console.log("===> out2: ", out2);

