package com.wixsite.mupbam1.resume.newfirebase

class User {
    var id:String? = null
    var name:String? = null
    var company:String? = null
    var email:String? = null

    constructor()
    constructor(id: String?, name: String?, company: String?, email: String?) {
        this.id = id
        this.name = name
        this.company = company
        this.email = email
    }

}