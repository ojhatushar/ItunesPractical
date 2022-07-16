package com.encora.encoraitunespractical.data.model.obj.xmlobj

import androidx.room.ColumnInfo
import androidx.room.Embedded
import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Namespace
import org.simpleframework.xml.Root


@Root(name = "price",strict = false)
@Namespace(prefix = "im", reference = "http://itunes.apple.com/rss")
data class ImPrice @JvmOverloads constructor(
		@field:Attribute(name="amount",required = false)
		@ColumnInfo(name = "amount")
		var label : String="",
		@field:Attribute(name="currency",required = false)
		@ColumnInfo(name = "currency")
		var currency : String="",
)