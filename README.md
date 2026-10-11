<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, viewport-fit=cover">
<title>Full Stack Development Lab · 3D</title>
<style>
:root{--bg:#1a1a2e;--panel:rgba(22,33,62,.85);--fg:#EDEAE0;--mut:#9aa0b4;--ac:#E94560;box-sizing:border-box;padding-top:env(safe-area-inset-top,0px);padding-bottom:env(safe-area-inset-bottom,0px)}
html,body{height:100%;margin:0}
body{background:var(--bg);color:var(--fg);font-family:system-ui,-apple-system,"Segoe UI",Roboto,sans-serif;overflow:hidden}
canvas{display:block;position:fixed;inset:0;touch-action:none}
header{position:fixed;top:env(safe-area-inset-top,0px);left:0;right:0;padding:18px 22px;pointer-events:none}
h1{margin:0;font-size:clamp(18px,3.2vw,30px);letter-spacing:.04em}
header p{margin:4px 0 0;color:var(--mut);font-size:13px}
#panel{position:fixed;right:18px;top:96px;width:min(320px,calc(100% - 36px));background:var(--panel);backdrop-filter:blur(8px);border:1px solid rgba(255,255,255,.12);border-radius:14px;padding:16px 18px;display:none}
#panel h2{margin:0 0 4px;font-size:17px}
#panel .tag{color:var(--ac);font-size:12px;font-weight:600;letter-spacing:.08em;text-transform:uppercase}
#panel p{margin:10px 0;font-size:14px;line-height:1.5}
#panel code{display:block;background:rgba(0,0,0,.35);padding:8px 10px;border-radius:8px;font-size:12px;overflow-x:auto;white-space:pre}
#panel button{position:absolute;top:8px;right:10px;background:none;border:0;color:var(--mut);font-size:20px;cursor:pointer}
#chips{position:fixed;left:0;right:0;bottom:env(safe-area-inset-bottom,0px);display:flex;gap:8px;overflow-x:auto;padding:12px 18px}
#chips button{flex:none;background:var(--panel);color:var(--fg);border:1px solid rgba(255,255,255,.14);border-radius:999px;padding:7px 14px;font-size:13px;cursor:pointer}
#chips button.on{background:var(--ac);border-color:var(--ac)}
#hint{position:fixed;left:22px;bottom:70px;color:var(--mut);font-size:12px;pointer-events:none}
</style>
</head>
<body>
<header><h1>FULL STACK DEVELOPMENT LAB</h1><p>React · Spring Boot · MongoDB · JUnit — drag to orbit, click a node</p></header>
<div id="panel"><button id="x" aria-label="Close">×</button><div class="tag" id="pt"></div><h2 id="pn"></h2><p id="pd"></p><code id="pr"></code></div>
<div id="hint">Drag to rotate · Click an experiment</div>
<div id="chips"></div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/three.js/r128/three.min.js"></script>
<script>
const C={web:0xF0B429,react:0x61DAFB,spring:0x9BD35A,mongo:0x13AA52,test:0xE94560};
const D=[
{id:'exp-4',n:'Registration form (JavaScript)',s:'HTML · CSS · vanilla JS',k:'web',d:'Form handling and validation with plain JavaScript.',r:'cd "exp-4 (registration using javascript)/orignal"\n# open index.html in a browser'},
{id:'exp-5',n:'Registration form (React)',s:'React',k:'react',d:'The same registration flow built with React state and controlled inputs.',r:'npm install\nnpm start'},
{id:'exp-6',n:'Shopping cart',s:'React',k:'react',d:'Cart app with add/remove items and totals via React state.',r:'npm install\nnpm start'},
{id:'exp-7',n:'Navigation',s:'React · React Router',k:'react',d:'Client-side routing with and without React Router.',r:'npm install\nnpm start'},
{id:'exp-8',n:'CRUD without an API',s:'Spring Boot · Maven',k:'spring',d:'CRUD operations in a Spring Boot app without a REST layer.',r:'mvn clean install\nmvn spring-boot:run'},
{id:'exp-9',n:'CRUD with an API',s:'Spring Boot · REST',k:'spring',d:'REST controllers exposing CRUD endpoints.',r:'mvn clean install\nmvn spring-boot:run'},
{id:'exp-11',n:'CRUD using MongoDB',s:'Spring Data MongoDB',k:'mongo',d:'Persistence with Spring Data MongoDB. Start a local MongoDB and set application.properties first.',r:'mvn spring-boot:run'},
{id:'exp-12',n:'JUnit testing',s:'Spring Boot · JUnit 5',k:'test',d:'Unit tests for a Spring Boot application using JUnit 5.',r:'mvn test'},
{id:'login',n:'Login / signup design',s:'HTML · CSS',k:'web',d:'Static login, signup and register page designs.',r:'# open index.html in a browser'}
];
const R=new THREE.WebGLRenderer({antialias:true,alpha:true});
R.setPixelRatio(Math.min(devicePixelRatio,2));R.setSize(innerWidth,innerHeight);document.body.prepend(R.domElement);
const S=new THREE.Scene();S.fog=new THREE.FogExp2(0x1a1a2e,.035);
const cam=new THREE.PerspectiveCamera(55,innerWidth/innerHeight,.1,100);cam.position.set(0,2.5,13);
S.add(new THREE.AmbientLight(0xffffff,.55));
const pl=new THREE.PointLight(0xffffff,1.3,60);pl.position.set(6,8,8);S.add(pl);
// center knot
const knot=new THREE.Mesh(new THREE.TorusKnotGeometry(1.6,.4,120,16),new THREE.MeshBasicMaterial({color:0xE94560,wireframe:true,transparent:true,opacity:.45}));
S.add(knot);
// stars
const sp=new Float32Array(1500);for(let i=0;i<1500;i++)sp[i]=(Math.random()-.5)*60;
const sg=new THREE.BufferGeometry();sg.setAttribute('position',new THREE.BufferAttribute(sp,3));
const stars=new THREE.Points(sg,new THREE.PointsMaterial({color:0xEDEAE0,size:.06,transparent:true,opacity:.7}));S.add(stars);
// ring of nodes
const G=new THREE.Group();S.add(G);
const nodes=[];
function label(t){const c=document.createElement('canvas');c.width=256;c.height=64;const x=c.getContext('2d');x.font='600 34px system-ui,sans-serif';x.fillStyle='#EDEAE0';x.textAlign='center';x.textBaseline='middle';x.fillText(t,128,34);
const sp=new THREE.Sprite(new THREE.SpriteMaterial({map:new THREE.CanvasTexture(c),transparent:true}));sp.scale.set(2.4,.6,1);return sp}
D.forEach((e,i)=>{
 const a=i/D.length*Math.PI*2,r=6;
 const m=new THREE.Mesh(new THREE.IcosahedronGeometry(.7,1),new THREE.MeshStandardMaterial({color:C[e.k],roughness:.35,metalness:.3,emissive:C[e.k],emissiveIntensity:.18}));
 m.position.set(Math.cos(a)*r,Math.sin(i*1.1)*1.3,Math.sin(a)*r);
 const l=label(e.id);l.position.y=1.3;m.add(l);
 m.add(new THREE.Mesh(new THREE.IcosahedronGeometry(.95,1),new THREE.MeshBasicMaterial({color:C[e.k],wireframe:true,transparent:true,opacity:.25})));
 m.userData={i,base:m.position.y,s:1};G.add(m);nodes.push(m);
});
// UI
const chips=document.getElementById('chips'),panel=document.getElementById('panel');
let sel=-1;
D.forEach((e,i)=>{const b=document.createElement('button');b.textContent=e.id;b.onclick=()=>pick(i);chips.appendChild(b)});
document.getElementById('x').onclick=()=>pick(-1);
function pick(i){
 sel=i;[...chips.children].forEach((b,j)=>b.classList.toggle('on',j===i));
 if(i<0){panel.style.display='none';return}
 const e=D[i];pt.textContent=e.s;pn.textContent=e.n;pd.textContent=e.d;pr.textContent=e.r;panel.style.display='block';
 // rotate group so node faces camera
 const m=nodes[i];tgt=-Math.atan2(m.position.z,m.position.x)+Math.PI/2;
 let d=tgt-G.rotation.y;d=Math.atan2(Math.sin(d),Math.cos(d));tgt=G.rotation.y+d;focus=true;
}
// interaction
let drag=false,moved=0,lx=0,vel=0,tgt=0,focus=false,mx=0,my=0;
const ray=new THREE.Raycaster(),ptr=new THREE.Vector2();
R.domElement.addEventListener('pointerdown',e=>{drag=true;moved=0;lx=e.clientX;focus=false});
addEventListener('pointerup',e=>{
 if(drag&&moved<5){
  ptr.set(e.clientX/innerWidth*2-1,-(e.clientY/innerHeight)*2+1);ray.setFromCamera(ptr,cam);
  const h=ray.intersectObjects(nodes,false)[0];pick(h?h.object.userData.i:-1);
 }drag=false});
addEventListener('pointermove',e=>{
 mx=e.clientX/innerWidth-.5;my=e.clientY/innerHeight-.5;
 if(drag){const dx=e.clientX-lx;lx=e.clientX;moved+=Math.abs(dx);vel=dx*.006;G.rotation.y+=vel}
});
addEventListener('resize',()=>{cam.aspect=innerWidth/innerHeight;cam.updateProjectionMatrix();R.setSize(innerWidth,innerHeight)});
// loop
const clk=new THREE.Clock();
(function loop(){
 requestAnimationFrame(loop);const t=clk.getElapsedTime();
 if(!drag){
  if(focus)G.rotation.y+=(tgt-G.rotation.y)*.06;
  else{vel*=.95;G.rotation.y+=vel+(sel<0?.003:0)}
 }
 knot.rotation.x=t*.25;knot.rotation.y=t*.35;stars.rotation.y=t*.01;
 nodes.forEach(m=>{const u=m.userData;m.rotation.y=t*.6+u.i;m.position.y=u.base+Math.sin(t*1.2+u.i)*.15;
  const ts=u.i===sel?1.5:1;u.s+=(ts-u.s)*.1;m.scale.setScalar(u.s)});
 cam.position.x+=(mx*3-cam.position.x)*.04;cam.position.y+=(2.5-my*2-cam.position.y)*.04;cam.lookAt(0,0,0);
 R.render(S,cam);
})();
</script>
</body>
</html>
