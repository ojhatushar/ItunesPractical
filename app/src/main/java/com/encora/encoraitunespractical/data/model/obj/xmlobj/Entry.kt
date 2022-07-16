package com.encora.encoraitunespractical.data.model.obj.xmlobj

import androidx.room.ColumnInfo
import androidx.room.Embedded
import com.encora.encoraitunespractical.data.model.obj.xmlobj.*
import com.google.gson.annotations.SerializedName
import org.simpleframework.xml.*
import java.io.Serializable



@Root(strict = false, name = "entry")
@Namespace(prefix = "im", reference = "http://itunes.apple.com/rss")
data class Entry (
    @field:Element(name="updated") var updated : String="",//1

    @field:Element(name="title") var title : String="",



    @field:ElementList(name="image" ,inline = true)
		@ColumnInfo(name = "image")
		 var image : List<ImImage>?= mutableListOf(),


    @field:ElementList(name="image" ,inline = true,required = false)
		@ColumnInfo(name = "image1")
		var image1 : List<String>?= mutableListOf(),

    @Embedded @field:Element(name="name") var name : String="",
		//val im:image : List<Im:image>,
    @SerializedName("collection")

		@Embedded @field:Element(name="collection" ,required = false) var collection : collection?=null,

    @Embedded @field:Element(name="price" ,required = false) var price : ImPrice?=null,

    @Embedded @field:Element(name="contentType" ,required = false) var contentType : ImContentType?=null,

    @field:Element(name="rights") var rights : String="",

    @field:ElementList(name="link" ,required = false ,inline = true)
		@ColumnInfo(name = "link")
		 var link  : List<Link>?=mutableListOf(),


    @Embedded @field:Element(name="releaseDate" ,required = false) var releaseDate : ImReleaseDate?=null,


    @Embedded @field:Element(name="id" ,required = false) var id : Id?=null,
    @Embedded @field:Element(name="category" ,required = false) var category : Category?=null,
    @Embedded @field:Element(name="artist" ,required = false) var imArtist : String?="",
    @Embedded @field:Element(name="content" ,required = false) var content : String=""
) : Serializable