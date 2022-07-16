package com.encora.encoraitunespractical.data.model.obj.xmlobj

import androidx.room.ColumnInfo
import org.simpleframework.xml.Element
import org.simpleframework.xml.Namespace
import org.simpleframework.xml.Root

@Root(strict = false, name = "uri")
@Namespace(prefix = "im", reference = "http://itunes.apple.com/rss")
data class Uri (
		@field:Element(name="label")
		@ColumnInfo(name = "label_Uri")
		var label : String=""
)