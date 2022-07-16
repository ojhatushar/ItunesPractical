package com.encora.encoraitunespractical.data.model.obj.xmlobj
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root




@Root(name = "attributes")
data class Attributes (

		@field:Element(name="rel")
		var rel : String="",
		@field:Element(name="type")
		var type : String="",
		@field:Element(name="href")
		var href : String=""
)