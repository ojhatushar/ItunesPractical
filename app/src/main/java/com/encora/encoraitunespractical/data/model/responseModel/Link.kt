package com.encora.encoraitunespractical.data.model.responseModel

import com.tickaroo.tikxml.annotation.Attribute
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "link")
data class Link(
    @Attribute(name = "title") var title: String? = null,
    @Attribute(name = "rel") var rel: String? = null,
    @Attribute(name = "type") var type: String? = null,
    @Attribute(name = "href") var href: String? = null,
    @PropertyElement(name = "im:duration") var duration: String? = null
)
