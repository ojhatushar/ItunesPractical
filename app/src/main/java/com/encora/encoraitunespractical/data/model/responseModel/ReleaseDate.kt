package com.encora.encoraitunespractical.data.model.responseModel

import com.tickaroo.tikxml.annotation.Attribute
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import com.tickaroo.tikxml.converter.htmlescape.HtmlEscapeStringConverter

@Xml(name = "im:releaseDate")
data class ReleaseDate(
    @Attribute(name = "label") var rdate: String? = null,
)