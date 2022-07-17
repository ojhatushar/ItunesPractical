package com.encora.encoraitunespractical.data.model.responseModel

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml


@Xml(name = "author")
data class Author(
    @PropertyElement(name = "name") var name: String? = null,
    @PropertyElement(name = "uri") var uri: String? = null
)
