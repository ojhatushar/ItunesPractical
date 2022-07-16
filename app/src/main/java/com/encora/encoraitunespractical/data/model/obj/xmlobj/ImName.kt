package com.encora.encoraitunespractical.data.model.obj.xmlobj

import androidx.room.ColumnInfo
import org.simpleframework.xml.Element
import org.simpleframework.xml.Namespace
import org.simpleframework.xml.Root


@Root(name = "im:name",strict = false)
@Namespace(prefix = "im", reference = "http://itunes.apple.com/rss")
data class ImName @JvmOverloads constructor(
		@field:Element(name="label")
		@ColumnInfo(name = "label_ImName")
		var label : String="",
		@ColumnInfo(name = "label_ImNameas")
		var labelgfd : String=""
)