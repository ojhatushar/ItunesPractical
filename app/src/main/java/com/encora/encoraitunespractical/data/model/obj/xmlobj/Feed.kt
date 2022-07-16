package com.encora.encoraitunespractical.data.model.obj.xmlobj

import androidx.annotation.NonNull
import androidx.room.*
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root


@Entity(tableName = "Feed")
@Root(strict = false,name = "Feed")
data class Feed @JvmOverloads constructor(

	@field:ElementList(name="entry" ,inline = true ,required = false)
		@ColumnInfo(name = "entry")
		var entry : List<Entry>?= mutableListOf(),

	@field:Element(name="updated")
		@Embedded
		var updated : String="",

	@field:Element(name="rights")
		@Embedded
		var rights : String="",

	@field:Element(name="title")
		@Embedded
		var title : String="",

	@field:Element(name="icon")
		@Embedded
		var icon : String="",



	@PrimaryKey(autoGenerate = false)
//@field:Element(name="id")
		@Embedded @NonNull
		var id : Id = Id()
)