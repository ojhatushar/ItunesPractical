package com.encora.encoraitunespractical.data.model.obj.xmlobj

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Namespace
import org.simpleframework.xml.Root


@Root(name = "category",strict = false)
@Namespace(prefix = "im", reference = "http://itunes.apple.com/rss")
data class Category  @JvmOverloads constructor(

		@field:Attribute(name="term",required = false) var term : String="",

		@field:Attribute(name="scheme",required = false) var scheme : String="",

		@field:Attribute(name="label",required = false) var label : String=""
)