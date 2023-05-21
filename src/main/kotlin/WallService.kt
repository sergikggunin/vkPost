class WallService {
    private var nextId = 1
    private val posts = mutableListOf<Post>()

    fun add(post: Post): Post {
        val newPost = post.copy(id = nextId++)
        posts.add(newPost)
        return newPost
    }

    fun update(updatedPost: Post): Boolean {
        val index = posts.indexOfFirst { it.id == updatedPost.id }
        return if (index != -1) {
            posts[index] = updatedPost
            true
        } else {
            false
        }
    }

    fun getPostById(id: Int): Post? {
        return posts.find { it.id == id }
    }
}
