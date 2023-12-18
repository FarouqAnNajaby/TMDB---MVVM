package com.example.repository.repository.remote.response

import com.google.gson.annotations.SerializedName

data class ResponseMovieList(

    @field:SerializedName("dates")
	var dates: Dates? = null,

    @field:SerializedName("page")
	var page: Int? = null,

    @field:SerializedName("total_pages")
	var totalPages: Int? = null,

    @field:SerializedName("results")
	var results: List<ResultsItem?>? = null,

    @field:SerializedName("total_results")
	var totalResults: Int? = null
) {
	data class Dates(

		@field:SerializedName("maximum")
		var maximum: String? = null,

		@field:SerializedName("minimum")
		var minimum: String? = null
	)

	data class ResultsItem(

		@field:SerializedName("overview")
		var overview: String? = null,

		@field:SerializedName("original_language")
		var originalLanguage: String? = null,

		@field:SerializedName("original_title")
		var originalTitle: String? = null,

		@field:SerializedName("video")
		var video: Boolean? = null,

		@field:SerializedName("title")
		var title: String? = null,

		@field:SerializedName("genre_ids")
		var genreIds: List<Int?>? = null,

		@field:SerializedName("poster_path")
		var posterPath: String? = null,

		@field:SerializedName("backdrop_path")
		var backdropPath: String? = null,

		@field:SerializedName("release_date")
		var releaseDate: String? = null,

		@field:SerializedName("popularity")
		var popularity: Any? = null,

		@field:SerializedName("vote_average")
		var voteAverage: Any? = null,

		@field:SerializedName("id")
		var id: Int? = null,

		@field:SerializedName("adult")
		var adult: Boolean? = null,

		@field:SerializedName("vote_count")
		var voteCount: Int? = null
	)
}
