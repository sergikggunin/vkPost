import org.junit.Test
import org.junit.Assert.*

class WallServiceTest {
    @Test
    fun addPost() {
        val service = WallService()
        val post = Post(
            id = 0,
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
            attachments = listOf(),
            geo = null,
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
        val result = service.add(post)
        assertNotEquals(0, result.id)
    }

    @Test
    fun updateExisting() {
        val service = WallService()
        val post1 = Post(
            id = 0,
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
            attachments = listOf(),
            geo = null,
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
        service.add(post1)

        val post2 = post1.copy(id = 1)
        service.add(post2)

        val update = post2.copy(text = "Updated")
        val result = service.update(update)
        assertTrue(result)
    }

    @Test
    fun updateNotExisting() {
        val service = WallService()
        val post1 = Post(
            id = 0,
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
            attachments = listOf(),
            geo = null,
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
        service.add(post1)

        val post2 = post1.copy(id = 1)
        service.add(post2)

        val update = post2.copy(id = 999, text = "Should not be updated")
        val result = service.update(update)
        assertFalse(result)
    }
}
