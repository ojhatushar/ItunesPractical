package com.encora.encoraitunespractical.data.model.obj.xmlobj

import androidx.room.ColumnInfo
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root



@Root(name = "title")
data class Title (

		@field:Element(name="label",required = false)
		@ColumnInfo(name = "label_Title")
		var label : String=""
)