classType = {},
core_toString = classType.toString,
jQuery.each("Boolean Number String Function Array Date RegExp Object        Error".split(" "), function(i, name) {
    classType[ "[object " + name + "]" ] = name.toLowerCase();
});
jQuery.extend({
    type: function( obj ) {
        if ( obj == null ) {
            return String( obj );
        }
        return typeof obj === "object" || typeof obj === "function" ?
        classType[ core_toString.call(obj) ] || "object" :
        typeof obj;
    }
});