package com.encora.encoraitunespractical.data.model.obj.xmlobj
import androidx.room.Embedded
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root



@Root(name = "author")
data class Author (

		@field:Element(name="name" , )
		@Embedded var name : String,

		@field:Element(name="uri")
		@Embedded var uri : String

)