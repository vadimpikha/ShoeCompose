package com.example.shoecompose.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Sneaker(
    @SerialName("box_condition")
    val boxCondition: String,
    @SerialName("brand_name")
    val brandName: String,
    @SerialName("category")
    val category: List<String>,
    @SerialName("collection_slugs")
    val collectionSlugs: List<String>,
    @SerialName("color")
    val color: String,
    @SerialName("designer")
    val designer: String,
    @SerialName("details")
    val details: String,
    @SerialName("gender")
    val gender: List<String>,
    @SerialName("grid_picture_url")
    val gridPictureUrl: String,
    @SerialName("has_picture")
    val hasPicture: Boolean,
    @SerialName("has_stock")
    val hasStock: Boolean,
    @SerialName("id")
    val id: Int,
    @SerialName("keywords")
    val keywords: List<String>,
    @SerialName("main_picture_url")
    val mainPictureUrl: String,
    @SerialName("midsole")
    val midsole: String?,
    @SerialName("name")
    val name: String,
    @SerialName("nickname")
    val nickname: String,
    @SerialName("original_picture_url")
    val originalPictureUrl: String,
    @SerialName("product_template_id")
    val productTemplateId: Int,
    @SerialName("release_date")
    val releaseDate: String?,
    @SerialName("release_date_unix")
    val releaseDateUnix: Int?,
    @SerialName("release_year")
    val releaseYear: Int?,
    @SerialName("retail_price_cents")
    val retailPriceCents: Int?,
    @SerialName("shoe_condition")
    val shoeCondition: String,
    @SerialName("silhouette")
    val silhouette: String,
    @SerialName("size_range")
    val sizeRange: List<Double>,
    @SerialName("sku")
    val sku: String,
    @SerialName("slug")
    val slug: String,
    @SerialName("status")
    val status: String,
    @SerialName("story_html")
    val storyHtml: String?,
    @SerialName("upper_material")
    val upperMaterial: String?
) {

    var isFavorite: Boolean = (1..100).random() > 50

}