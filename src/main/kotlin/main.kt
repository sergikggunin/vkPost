fun main() {
    val wallService = WallService()

    val post1 = Post(
        id = 1,
        ownerId = 123,
        fromId = 456,
        createdBy = null,
        date = 1623456789,
        text = "Hello, world!",
        replyOwnerId = 789,
        replyPostId = 10,
        friendsOnly = false,
        comments = Comments(10, true, true, true, true),
        likes = Likes(20, false, true, true),
        reposts = Reposts(5, false),
        views = Views(100),
        postType = "post",
        postSource = PostSource("type", "platform", "data", "url"),
        attachments = listOf(
            Attachment("photo", Photo(1, 1, 123, 456, emptyList(), "Photo 1")),
            Attachment("photo", Photo(2, 1, 123, 457, emptyList(), "Photo 2"))
        ),
        geo = Geo("type", "coordinates", Place(1, "Place 1", 0.0, 0.0, 1623456789, "icon", 10)),
        signerId = null,
        copyHistory = emptyList(),
        canPin = true,
        canDelete = true,
        canEdit = true,
        isPinned = false,
        markedAsAds = false,
        isFavorite = false,
        donut = null,
        postponedId = null
    )

    wallService.add(post1)

    val post2 = Post(
        id = 2,
        ownerId = 789,
        fromId = 789,
        createdBy = 123,
        date = 1623456799,
        text = "Post 2",
        replyOwnerId = 456,
        replyPostId = 20,
        friendsOnly = true,
        comments = Comments(5, true, false, false, false),
        likes = Likes(10, true, false, false),
        reposts = Reposts(2, true),
        views = Views(50),
        postType = "post",
        postSource = null,
        attachments = emptyList(),
        geo = null,
        signerId = 123,
        copyHistory = emptyList(),
        canPin = false,
        canDelete = true,
        canEdit = true,
        isPinned = true,
        markedAsAds = false,
        isFavorite = true,
        donut = Donut(true, 30, "Donut Placeholder", true, "all"),
        postponedId = null
    )

    wallService.add(post2)

    val postById = wallService.getPostById(1)
    println("Post by ID: $postById")

    val updatedPost = post1.copy(likes = Likes(21, true, true, true))
    wallService.update(updatedPost)
    val updatedPostById = wallService.getPostById(1)
    println("Updated post by ID: $updatedPostById")

    val postNotFound = wallService.getPostById(999)
    println("Post not found: $postNotFound")
}
