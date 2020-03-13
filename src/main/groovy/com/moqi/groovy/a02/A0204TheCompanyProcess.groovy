package com.moqi.groovy.a02

import com.moqi.groovy.Data

/**
 * @author moqi* On 3/13/20 22:54
 */
class A0204TheCompanyProcess {

    static void main(String[] args) {
        def names = cleanUpNames(Data.NAME_LIST)
        println "names = $names"
    }

    static String cleanUpNames(List<String> listOfNames) {
        listOfNames
                .findAll { it.length() > 1 }
                .collect { it.capitalize() }
                .join ','
    }

}
