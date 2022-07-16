package com.encora.encoraitunespractical.data.model.obj.xmlobj

import androidx.room.ColumnInfo
import androidx.room.Embedded
import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Namespace
import org.simpleframework.xml.Root



@Root(strict = false, name = "releaseDate")
@Namespace(prefix = "im", reference = "http://itunes.apple.com/rss")
data class ImReleaseDate (
		@field:Attribute(name="label",required = false)
		@ColumnInfo(name = "label_ImReleaseDate")
		var label : String="",
		@ColumnInfo(name = "label_as")
		@Embedded var attributes : String=""
)