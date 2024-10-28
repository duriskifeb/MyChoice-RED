window.onload=function(){
    fetch(`wilayah.json`)
    // fetch(`https://www.emsifa.com/api-wilayah-indonesia/api/provinces.json`)
    .then(response => response.json())
    .then(data => {
        var provinsi = JSON.parse(JSON.stringify(data.provinsi));
        var prov = document.getElementById('prov');
        var kabkota = document.getElementById('kabkota');
        var kec = document.getElementById('kec');
        var kel = document.getElementById('kel');

        prov.innerHTML=`<option value="">- Pilih Provinsi -</option>`;
        for(let key in provinsi) { 
            prov.innerHTML+= `<option value="${key}">${provinsi[key]}</option>`;
          }
        
        prov.addEventListener('change',function(){
            var kab = JSON.parse(JSON.stringify(data.kabupaten));
            kabkota.innerHTML=`<option value="">- Pilih Kabupaten/kota -</option>`;
            for(let k in kab[prov.value]) { 
                kabkota.innerHTML+= `<option value="${k}">${kab[prov.value][k]}</option>`;
              }
        });

        kabkota.addEventListener('change',function(){
            var kecamatan = JSON.parse(JSON.stringify(data.kecamatan));            
            kec.innerHTML=`<option value="">- Pilih Kecamatan -</option>`;
            for(let k in kecamatan[prov.value+kabkota.value]) { 
                kec.innerHTML+= `<option value="${k}">${kecamatan[prov.value+kabkota.value][k]}</option>`;
            }

        });

        kec.addEventListener('change',function(){
            var kelurahan = JSON.parse(JSON.stringify(data.kelurahan));            
            kel.innerHTML=`<option value="">- Pilih Kelurahan -</option>`;
            for(let k in kelurahan[prov.value+kabkota.value+kec.value]) { 
                kel.innerHTML+= `<option value="${k}">${kelurahan[prov.value+kabkota.value+kec.value][k]}</option>`;
            }

        });
    });

    
};

