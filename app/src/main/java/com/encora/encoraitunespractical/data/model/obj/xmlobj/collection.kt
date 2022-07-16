package com.encora.encoraitunespractical.data.model.obj.xmlobj

import org.simpleframework.xml.Element
import org.simpleframework.xml.Namespace
import org.simpleframework.xml.Root



@Root(name = "im:collection",strict = false)
@Namespace(prefix = "im", reference = "http://itunes.apple.com/rss")
data class collection @JvmOverloads constructor(
	@field:Element(name="name") var  name: String="",
	@field:Element(name="link") var link : Link?=null,
	@field:Element(name="contentType") var contentType : ImContentType?=null
)