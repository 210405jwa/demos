(()=>{"use strict";function e(e,o){for(var r=0;r<o.length;r++){var n=o[r];n.enumerable=n.enumerable||!1,n.configurable=!0,"value"in n&&(n.writable=!0),Object.defineProperty(e,n.key,n)}}var o=function(){function o(e,r,n,t){!function(e,o){if(!(e instanceof o))throw new TypeError("Cannot call a class as a function")}(this,o),this.horsepower=e,this.color=r,this.year=n,this.model=t}var r,n;return r=o,(n=[{key:"getHorsepower",value:function(){return this.horsepower}},{key:"getColor",value:function(){return this.color}},{key:"getYear",value:function(){return this.year}},{key:"getModel",value:function(){return this.model}}])&&e(r.prototype,n),o}();console.log(2.718),console.log(3.14);var r=new o(300,"Red",2010,"Mustang");console.log(r),console.log(r.getHorsepower())})();