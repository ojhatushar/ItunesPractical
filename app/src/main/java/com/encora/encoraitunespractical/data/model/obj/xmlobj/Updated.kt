package com.encora.encoraitunespractical.data.model.obj.xmlobj

import androidx.room.ColumnInfo
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root


@Root(name = "updated")
data class Updated (
		@field:Element(name="label" ,required = false)
		@ColumnInfo(name = "label_Updated")
		var label : String=""
)