
### Búsqueda de coordenadas en la página

```javascript
    document.onmousemove = function(e)
    {
        var x = e.pageX;
        var y = e.pageY;
        // do what you want with x and y
    };
    document.onclick = function(e)
    {
        var x = e.pageX;
        var y = e.pageY;
        alert("User clicked at position (" + x + "," + y + ")")
    };
```