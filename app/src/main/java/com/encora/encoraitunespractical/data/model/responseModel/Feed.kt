package com.encora.encoraitunespractical.data.model.responseModel

import com.encora.encoraitunespractical.data.model.responseModel.Author
import com.encora.encoraitunespractical.data.model.responseModel.Entry
import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml


@Xml(name = "feed")
data class Feed(
    @PropertyElement(name = "id") var id: String? = null,
    @PropertyElement(name = "title") var title: String? = null,
    @PropertyElement(name = "updated") var updated: String? = null,
    @PropertyElement(name = "icon") var icon: String? = null,
    @Element(name = "author") var author: Author? = null,
    @PropertyElement(name = "rights") var rights: String? = null,
    @Element(name = "entry") var entries: List<Entry>? = null
)





