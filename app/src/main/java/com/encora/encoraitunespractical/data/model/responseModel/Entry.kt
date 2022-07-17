package com.encora.encoraitunespractical.data.model.responseModel

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import com.tickaroo.tikxml.converter.htmlescape.HtmlEscapeStringConverter

@Xml(name = "entry")
data class Entry(
    @PropertyElement(name = "id") var id: String? = null,
    @PropertyElement(
        name = "title", converter = HtmlEscapeStringConverter::class
    ) var title: String?,
    @PropertyElement(name = "im:image") var image: String? = null,
    @PropertyElement(
        name = "im:name",
        converter = HtmlEscapeStringConverter::class
    ) var name: String? = null,
    @PropertyElement(
        name = "im:artist",
        converter = HtmlEscapeStringConverter::class
    ) var artist: String?,
    @PropertyElement(name = "im:price") var price: String? = null,
    @PropertyElement(
        name = "rights",
        converter = HtmlEscapeStringConverter::class
    ) var rights: String? = null,
    @PropertyElement(
        name = "content",
        converter = HtmlEscapeStringConverter::class
    ) var content: String,

    @Element var link: Link? = null,
    @Element var category: Category? = null,
    @Element(name = "im:collection") var collection: Collection? = null,
    @Element(name = "im:releaseDate") var releaseDate: ReleaseDate? = null
)

