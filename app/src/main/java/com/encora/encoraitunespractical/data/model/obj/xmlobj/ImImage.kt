package com.encora.encoraitunespractical.data.model.obj.xmlobj

import androidx.room.ColumnInfo
import androidx.room.Embedded
import org.simpleframework.xml.*


@Root(name = "image",strict = false)
@Namespace(prefix = "im", reference = "http://itunes.apple.com/rss")
data class ImImage @JvmOverloads constructor(
		@field:Attribute(name="height",required = false)
		var height:Int=0,
		@field:Element(name="_text",required = false)
		var text: String=""

/*@field:Element(name="label")
@ColumnInfo(name = "label_ImImage")
val label : String="",
@field:Element(name="attributes")
@Embedded val attributes : Attributes*/
)