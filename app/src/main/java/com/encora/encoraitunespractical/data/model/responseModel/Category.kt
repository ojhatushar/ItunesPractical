package com.encora.encoraitunespractical.data.model.responseModel

import com.tickaroo.tikxml.annotation.Attribute
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "category")
data class Category(
    @Attribute(name = "label") var label: String? = null
)