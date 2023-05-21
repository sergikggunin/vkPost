data class Post(
    val id: Int,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int?,
    val date: Int,
    val text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Boolean,
    val comments: Comments,
    val likes: Likes,
    val reposts: Reposts,
    val views: Views,
    val postType: String,
    val postSource: PostSource?,
    val attachments: List<Attachment>,
    val geo: Geo?,
    val signerId: Int?,
    val copyHistory: List<Post>,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val donut: Donut?,
    val postponedId: Int?
)

data class Comments(
    val count: Int,
    val canPost: Boolean,
    val groupsCanPost: Boolean,
    val canClose: Boolean,
    val canOpen: Boolean
)

data class Likes(
    val count: Int,
    val userLikes: Boolean,
    val canLike: Boolean,
    val canPublish: Boolean
)

data class Reposts(
    val count: Int,
    val userReposted: Boolean
)

data class Views(
    val count: Int
)

data class PostSource(
    val type: String,
    val platform: String?,
    val data: String?,
    val url: String?
)

data class Attachment(
    val type: String,
    val photo: Photo?,
)

data class Photo(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val userId: Int,
    val sizes: List<Size>,
    val text: String,
)

data class Size(
    val type: String,
    val url: String,
    val width: Int,
    val height: Int
)

data class Geo(
    val type: String,
    val coordinates: String,
    val place: Place
)

data class Place(
    val id: Int,
    val title: String,
    val latitude: Double,
    val longitude: Double,
    val created: Int,
    val icon: String,
    val checkins: Int,
)

data class Donut(
    val isDonut: Boolean,
    val paidDuration: Int?,
    val placeholder: String?,
    val canPublishFreeCopy: Boolean,
    val editMode: String?
)
