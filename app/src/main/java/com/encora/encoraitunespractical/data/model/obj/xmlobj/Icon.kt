package com.encora.encoraitunespractical.data.model.obj.xmlobj

import androidx.room.ColumnInfo
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root


@Root(name = "icon")
data class Icon (

		@field:Element(name="label" , required=false)
		@ColumnInfo(name = "label_Icon")
		var label : String

)