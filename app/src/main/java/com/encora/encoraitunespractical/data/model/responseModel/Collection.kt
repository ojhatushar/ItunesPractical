package com.encora.encoraitunespractical.data.model.responseModel

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import com.tickaroo.tikxml.converter.htmlescape.HtmlEscapeStringConverter

@Xml(name = "im:collection")
data class Collection(
    @PropertyElement(name = "im:name", converter = HtmlEscapeStringConverter::class) var collectionName: String? = null,
)