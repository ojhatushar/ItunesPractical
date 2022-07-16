package com.encora.encoraitunespractical.data.model.obj.xmlobj

import androidx.room.Embedded
import org.simpleframework.xml.*


@Root(name = "im:contentType",strict = false)
@Namespace(prefix = "im", reference = "http://itunes.apple.com/rss")
data class ImContentType @JvmOverloads constructor(
		//@Embedded   @SerializedName("im:contentType")val imContentType : ImContentType,
		@field:Attribute(name="term",required = false)
		@Embedded var term : String="",

		@field:Attribute(name="label",required = false)
		@Embedded var label : String=""
)