package com.encora.encoraitunespractical.data.model.obj.xmlobj

import androidx.room.ColumnInfo
import androidx.room.Embedded
import org.simpleframework.xml.Element
import org.simpleframework.xml.Namespace
import org.simpleframework.xml.Root

@Root(name = "artist",strict = false)
@Namespace(prefix = "im", reference = "http://itunes.apple.com/rss")
data class ImArtist @JvmOverloads constructor(
		@field:Element(name="label" ,required = false)
		@ColumnInfo(name = "label_ImArtist")
		var label : String="",

		@field:Element(name="href", required = false)
		@Embedded var href : String=""
)