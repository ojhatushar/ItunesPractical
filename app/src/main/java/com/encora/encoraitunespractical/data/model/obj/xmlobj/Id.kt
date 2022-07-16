package com.encora.encoraitunespractical.data.model.obj.xmlobj

import androidx.room.ColumnInfo
import org.simpleframework.xml.Element
import org.simpleframework.xml.Namespace
import org.simpleframework.xml.Root




@Root(name = "id",strict = false)
@Namespace(prefix = "im", reference = "http://itunes.apple.com/rss")
data class Id @JvmOverloads constructor(
		@ColumnInfo(name = "label_id")
		@field:Element(name="label", required=false )
		var label : String="",
		/*@ColumnInfo(name = "labelone")
		var labelone : String=""*/


)