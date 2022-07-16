package com.encora.encoraitunespractical.data.model.obj.xmlobj

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName
import org.simpleframework.xml.Attribute

import org.simpleframework.xml.Element
import org.simpleframework.xml.Namespace
import org.simpleframework.xml.Root


@Root(strict = false, name = "link")
@Namespace(prefix = "im", reference = "http://itunes.apple.com/rss")
data class Link @JvmOverloads constructor(

		/*@field:Element(name="rel" ,required = false)
		@Embedded @SerializedName("rel") val rel: String,

		@field:Element(name="href" ,required = false)
		@Embedded @SerializedName("href") val href: String,

		@field:Element(name="duration")
		 @SerializedName("duration") val duration: String,
		@field:Element(name="im:attributes")
		@Embedded val attributes : Attributes*/

		@field:Attribute(name="rel" ,required = false)
		@Embedded @SerializedName("rel") var rel: String="",

		@field:Attribute(name="href" ,required = false)
		@Embedded @SerializedName("href") var href: String="",

		@field:Element(name="duration",required = false) var duration: String="",


		@field:Attribute(name="type" ,required = false)
		@Embedded @SerializedName("type") var type: String="",

		@field:Attribute(name="assetType" ,required = false)
		@Embedded @SerializedName("assetType") var assetType: String="",

		@field:Attribute(name="title" ,required = false)
		@Embedded @SerializedName("title") var title: String="",


		/*@field:Element(name="im:attributes")
		@Embedded val attributes : Attributes*/
)