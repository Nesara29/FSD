<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, viewport-fit=cover">
<title>FSD Lab — 3D VFX Experiment Sheet</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Space+Grotesk:wght@400;600;700&family=JetBrains+Mono:wght@400;600&display=swap">
<style>
:root{--bg:#030712;--ink:#e8eefc;--mut:#8b97b5;--c1:#22d3ee;--c2:#a855f7;--c3:#f472b6;--glass:rgba(255,255,255,.06);--line:rgba(255,255,255,.14);
box-sizing:border-box;padding-top:env(safe-area-inset-top,0px);padding-bottom:env(safe-area-inset-bottom,0px);color-scheme:dark}
html{scroll-behavior:smooth;scroll-padding-top:env(safe-area-inset-top,0px)}
*,*::before,*::after{box-sizing:inherit}
body{margin:0;background:var(--bg);color:var(--ink);font:400 16px/1.6 'Space Grotesk',system-ui,sans-serif;overflow-x:hidden}
#gl{position:fixed;inset:0;width:100%;height:100%;z-index:0}
.grid{position:fixed;inset:0;z-index:1;pointer-events:none;background:linear-gradient(var(--line) 1px,transparent 1px) 0 0/60px 60px,linear-gradient(90deg,var(--line) 1px,transparent 1px) 0 0/60px 60px;opacity:.12;mask-image:radial-gradient(circle at 50% 40%,#000,transparent 70%);-webkit-mask-image:radial-gradient(circle at 50% 40%,#000,transparent 70%)}
main{position:relative;z-index:2}
nav{position:fixed;top:env(safe-area-inset-top,0px);left:0;right:0;z-index:5;display:flex;justify-content:space-between;align-items:center;padding:14px clamp(16px,4vw,48px);backdrop-filter:blur(12px);-webkit-backdrop-filter:blur(12px);background:rgba(3,7,18,.45);border-bottom:1px solid var(--line)}
nav b{font-family:'JetBrains Mono',monospace;letter-spacing:.12em;font-size:13px}
nav a{color:var(--mut);text-decoration:none;font-size:13px;margin-left:18px;transition:color .3s}
nav a:hover{color:var(--c1)}
.bar{position:fixed;top:0;left:0;height:3px;width:0;z-index:6;background:linear-gradient(90deg,var(--c1),var(--c2),var(--c3))}
section{min-height:100vh;padding:110px clamp(16px,5vw,64px) 60px;max-width:1200px;margin:auto}
.hero{display:flex;flex-direction:column;justify-content:center;min-height:100vh}
.tag{font:600 12px 'JetBrains Mono',monospace;color:var(--c1);letter-spacing:.3em;text-transform:uppercase}
h1{font-size:clamp(44px,9vw,120px);line-height:.95;margin:.2em 0;letter-spacing:-.04em;font-weight:700}
.g{background:linear-gradient(100deg,var(--c1),var(--c2) 50%,var(--c3));-webkit-background-clip:text;background-clip:text;color:transparent;background-size:200% auto;animation:flow 6s linear infinite}
@keyframes flow{to{background-position:200% center}}
.lead{max-width:620px;color:var(--mut);font-size:18px}
.cta{display:inline-block;margin-top:28px;padding:14px 28px;border-radius:99px;border:1px solid var(--c1);color:var(--c1);text-decoration:none;font-weight:600;position:relative;overflow:hidden;transition:.3s}
.cta:hover{background:var(--c1);color:#001018;box-shadow:0 0 40px var(--c1)}
.h2{font-size:clamp(30px,5vw,56px);letter-spacing:-.03em;margin:0 0 8px}
.cards{display:grid;grid-template-columns:repeat(auto-fit,minmax(260px,1fr));gap:20px;margin-top:36px;perspective:1000px}
.card{position:relative;padding:24px;border-radius:20px;background:var(--glass);border:1px solid var(--line);backdrop-filter:blur(12px);-webkit-backdrop-filter:blur(12px);transform-style:preserve-3d;transition:transform .15s,border-color .3s,box-shadow .3s;cursor:pointer;overflow:hidden}
.card::before{content:"";position:absolute;inset:0;background:radial-gradient(240px circle at var(--mx,50%) var(--my,0%),var(--ac),transparent 70%);opacity:0;transition:.3s;mix-blend-mode:screen}
.card:hover,.card.on{border-color:var(--ac);box-shadow:0 0 40px -10px var(--ac)}
.card:hover::before,.card.on::before{opacity:.28}
.card>*{position:relative;transform:translateZ(30px)}
.n{font:600 12px 'JetBrains Mono',monospace;color:var(--ac)}
.card h3{margin:6px 0;font-size:21px}
.card p{margin:0 0 12px;color:var(--mut);font-size:14px}
.chips{display:flex;flex-wrap:wrap;gap:6px}
.chips span{font:400 11px 'JetBrains Mono',monospace;padding:3px 9px;border-radius:99px;border:1px solid var(--line);color:var(--ink)}
.rv{opacity:0;transform:translateY(40px) scale(.97);filter:blur(8px);transition:opacity .9s,transform .9s,filter .9s}
.rv.in{opacity:1;transform:none;filter:none}
.panel{margin-top:32px;padding:clamp(18px,3vw,32px);border-radius:24px;background:var(--glass);border:1px solid var(--line);backdrop-filter:blur(14px);-webkit-backdrop-filter:blur(14px)}
.two{display:grid;grid-template-columns:repeat(auto-fit,minmax(280px,1fr));gap:24px}
label{font:600 11px 'JetBrains Mono',monospace;color:var(--mut);letter-spacing:.1em}
input,select{width:100%;margin:6px 0 4px;padding:12px 14px;border-radius:12px;border:1px solid var(--line);background:rgba(0,0,0,.35);color:var(--ink);font:inherit;outline:none;transition:.3s}
input:focus,select:focus{border-color:var(--c1);box-shadow:0 0 0 3px rgba(34,211,238,.2)}
.err{height:16px;font-size:12px;color:var(--c3)}
.ok{color:var(--c1)}
.api{display:flex;gap:10px;align-items:center;padding:10px 0;border-bottom:1px dashed var(--line);font:400 13px 'JetBrains Mono',monospace;flex-wrap:wrap}
.m{padding:2px 10px;border-radius:6px;font-weight:600;font-size:11px;min-width:60px;text-align:center}
.POST{background:#0f766e}.GET{background:#1d4ed8}.PUT{background:#a16207}.DELETE{background:#be123c}
.api i{font-style:normal;color:var(--mut);margin-left:auto}
.api.fire{animation:pulse .8s}
@keyframes pulse{0%{background:rgba(34,211,238,.35)}100%{background:transparent}}
.flow{display:flex;gap:8px;align-items:center;flex-wrap:wrap;margin-top:18px;font:600 12px 'JetBrains Mono',monospace}
.flow b{padding:8px 12px;border-radius:10px;border:1px solid var(--c2);background:rgba(168,85,247,.12)}
.flow s{text-decoration:none;color:var(--c1);animation:blink 1.4s infinite}
@keyframes blink{50%{opacity:.2}}
pre{margin:14px 0 0;padding:16px;border-radius:14px;background:rgba(0,0,0,.45);border:1px solid var(--line);overflow-x:auto;font:400 12.5px/1.6 'JetBrains Mono',monospace;color:#c8d6f5}
table{width:100%;border-collapse:collapse;font-size:14px}
.tw{overflow-x:auto}
td,th{padding:12px 10px;text-align:left;border-bottom:1px solid var(--line);vertical-align:top}
th{font:600 11px 'JetBrains Mono',monospace;color:var(--c1);letter-spacing:.1em}
td:first-child{white-space:nowrap;font-weight:600}
footer{position:relative;z-index:2;text-align:center;padding:40px 16px;color:var(--mut);font-size:13px}
.cur{position:fixed;width:18px;height:18px;border:1.5px solid var(--c1);border-radius:50%;pointer-events:none;z-index:9;transform:translate(-50%,-50%);transition:width .2s,height .2s,background .2s;mix-blend-mode:screen}
.cur.h{width:54px;height:54px;background:rgba(34,211,238,.15)}
@media(hover:none){.cur{display:none}}
@media(max-width:640px){nav a{display:none}}
@media(prefers-reduced-motion:reduce){*{animation:none!important;transition:none!important}.rv{opacity:1;transform:none;filter:none}}
</style>
</head>
<body>
<div class="bar" id="bar"></div><div class="cur" id="cur"></div>
<canvas id="gl"></canvas><div class="grid"></div>
<nav><b>FSD // LAB</b><div><a href="#lab">Experiments</a><a href="#live">Live</a><a href="#ai">AI</a><a href="#research">Research</a></div></nav>
<main>
<section class="hero">
  <div class="tag">Full Stack Development · Experiment Sheet</div>
  <h1>Eight labs.<br><span class="g">One 3D universe.</span></h1>
  <p class="lead">Every experiment from your FSD folder — JavaScript, React, Spring Boot CRUD, MongoDB, JUnit — rebuilt as an interactive, motion-driven sheet. Move the mouse, scroll, hover a card: the 3D core morphs for each experiment.</p>
  <a class="cta" href="#lab">Enter the lab ↓</a>
</section>

<section id="lab">
  <div class="tag rv">01 · All experiments</div>
  <h2 class="h2 rv">Experiment sheet</h2>
  <p class="lead rv">Hover or tap a card to change the 3D shape behind it.</p>
  <div class="cards" id="cards"></div>
</section>

<section id="live">
  <div class="tag rv">02 · Live demos</div>
  <h2 class="h2 rv">Exp-4 &amp; Exp-9 in action</h2>
  <div class="two">
    <div class="panel rv">
      <div class="n tag">EXP-4 · Registration form (JS validation)</div>
      <form id="f" novalidate>
        <label>FIRST NAME</label><input id="fn" placeholder="Enter your first name"><div class="err" id="e1"></div>
        <label>STATE</label><select id="st"><option value="">-- Select Your State --</option><option>Andhra Pradesh</option><option>Tamil Nadu</option><option>Karnataka</option><option>Kerala</option><option>Goa</option></select><div class="err" id="e2"></div>
        <label>PHONE (10 DIGITS)</label><input id="ph" inputmode="numeric" placeholder="10-digit phone number"><div class="err" id="e3"></div>
        <label>EMAIL</label><input id="em" type="email" placeholder="you@gmail.com"><div class="err" id="e4"></div>
        <button class="cta" style="background:none;cursor:pointer;font:inherit;font-weight:600;margin-top:6px">Register</button>
        <div class="err" id="e5" style="margin-top:8px"></div>
      </form>
    </div>
    <div class="panel rv">
      <div class="n tag">EXP-9 · CRUD with REST API (Spring Boot)</div>
      <p class="lead" style="font-size:14px">Click an endpoint to fire a request through the pipeline.</p>
      <div id="apis"></div>
      <div class="flow"><b>Browser</b><s>▸▸</s><b>@RestController</b><s>▸▸</s><b>CustRepo</b><s>▸▸</s><b>DB</b></div>
      <pre id="log">// waiting for request…</pre>
    </div>
  </div>
</section>

<section id="ai">
  <div class="tag rv">03 · AI platform connection</div>
  <h2 class="h2 rv">Plug the lab into an AI</h2>
  <p class="lead rv">Add a small Spring Boot endpoint that forwards a prompt to an AI API, so any experiment (e.g. Exp-9 Customer CRUD) can get an assistant: "summarize customers", "suggest validation rules". Keep the API key on the server only.</p>
  <div class="panel rv">
<pre>@RestController
public class AiController {
  @Value("${ai.api.key}") String key;          // application.properties / env var
  @PostMapping("/ask")
  public String ask(@RequestBody String prompt) {
    // POST https://api.anthropic.com/v1/messages
    // headers: x-api-key, anthropic-version, content-type
    // body: { model, max_tokens, messages:[{role:"user",content:prompt}] }
    return client.send(prompt);                  // return text to the browser
  }
}</pre>
  <div class="flow"><b>UI (this page)</b><s>▸▸</s><b>Spring /ask</b><s>▸▸</s><b>AI API</b><s>▸▸</s><b>Answer in 3D UI</b></div>
  </div>
</section>

<section id="research">
  <div class="tag rv">04 · Web research → design decisions</div>
  <h2 class="h2 rv">Why this design</h2>
  <div class="panel rv tw"><table>
    <tr><th>FINDING (WEB)</th><th>APPLIED HERE</th></tr>
    <tr><td>Dark cyber look: #030712 base, cyan / purple / pink accents, glass cards, 3D tilt</td><td>Same palette, 12px-blur glass cards, mouse-driven tilt + glow</td></tr>
    <tr><td>One strong visual idea, scroll-driven chapters, mobile-first</td><td>One morphing 3D core; each experiment is a chapter; responsive grid</td></tr>
    <tr><td>Three.js + scroll reveals via IntersectionObserver for performance</td><td>Wireframe core, particle field, reveal-on-scroll</td></tr>
    <tr><td>Animation must communicate, respect reduced-motion</td><td>Motion tied to hover/scroll/API events; reduced-motion switch</td></tr>
  </table></div>
  <p class="lead rv" style="margin-top:20px;font-size:14px">Sources: SuperDesign "Hyper-Interactive 3D Developer Portfolio", svilenkovic.com 3D trends 2026, Lollypop 2026 web trends.</p>
</section>
</main>
<footer>Built with HTML · CSS · JavaScript · Three.js — from your FSD.zip</footer>

<script src="https://cdnjs.cloudflare.com/ajax/libs/three.js/r128/three.min.js"></script>
<script>
const EXP=[
 ["EXP-4","Registration (JavaScript)","HTML form with JS validation: name, state, phone, email.",["HTML","CSS","JS"],"#22d3ee",()=>new THREE.TorusKnotGeometry(1,.3,120,16)],
 ["EXP-5","Registration (React)","React registration form project (folder empty in ZIP).",["React"],"#61dafb",()=>new THREE.IcosahedronGeometry(1.3,1)],
 ["EXP-6","Shopping Cart (React)","React shopping cart project (folder empty in ZIP).",["React"],"#a855f7",()=>new THREE.OctahedronGeometry(1.4,1)],
 ["EXP-7","Navigation (React Router)","Navigation page and React Router app (folders empty in ZIP).",["React","Router"],"#f472b6",()=>new THREE.TorusGeometry(1.1,.45,16,60)],
 ["EXP-8","CRUD without API","Spring Boot + JSP views: index, display, update, delete.",["Spring Boot","JSP","JPA"],"#facc15",()=>new THREE.DodecahedronGeometry(1.4,0)],
 ["EXP-9","CRUD with REST API","Customer REST controller: addCust, getCust, updCust, delCust.",["REST","Spring Boot","JPA"],"#34d399",()=>new THREE.ConeGeometry(1.2,2.2,6,4)],
 ["EXP-11","CRUD with MongoDB","Customer CRUD using Spring Data MongoDB repository.",["MongoDB","Spring Data"],"#4ade80",()=>new THREE.CylinderGeometry(1,1,2,10,5)],
 ["EXP-12","JUnit Testing","Store entity with StoreRepo and StoreRepoTest.",["JUnit","JPA"],"#fb7185",()=>new THREE.BoxGeometry(1.8,1.8,1.8,4,4,4)]
];
const $=s=>document.querySelector(s);
/* cards */
const cw=$('#cards');
EXP.forEach((e,i)=>{const d=document.createElement('div');d.className='card rv';d.style.setProperty('--ac',e[4]);d.style.transitionDelay=(i%4)*90+'ms';
 d.innerHTML=`<div class="n">${e[0]}</div><h3>${e[1]}</h3><p>${e[2]}</p><div class="chips">${e[3].map(t=>`<span>${t}</span>`).join('')}</div>`;
 d.onmouseenter=d.onclick=()=>morph(i);
 d.onmousemove=ev=>{const r=d.getBoundingClientRect(),x=(ev.clientX-r.left)/r.width,y=(ev.clientY-r.top)/r.height;
  d.style.setProperty('--mx',x*100+'%');d.style.setProperty('--my',y*100+'%');
  d.style.transform=`rotateY(${(x-.5)*14}deg) rotateX(${(.5-y)*14}deg) translateZ(8px)`};
 d.onmouseleave=()=>d.style.transform='';cw.appendChild(d)});
/* reveal + progress */
const io=new IntersectionObserver(es=>es.forEach(x=>x.isIntersecting&&x.target.classList.add('in')),{threshold:.15});
document.querySelectorAll('.rv').forEach(el=>io.observe(el));
addEventListener('scroll',()=>{const h=document.documentElement;$('#bar').style.width=scrollY/(h.scrollHeight-innerHeight)*100+'%'},{passive:true});
/* cursor */
const cur=$('#cur');addEventListener('pointermove',e=>{cur.style.left=e.clientX+'px';cur.style.top=e.clientY+'px';cur.classList.toggle('h',!!e.target.closest('.card,a,button'))});
/* exp-4 validation */
$('#f').onsubmit=ev=>{ev.preventDefault();const v=id=>$(id).value.trim();let ok=true;
 const set=(id,m)=>{$(id).textContent=m;if(m)ok=false};
 set('#e1',v('#fn').length<2?'Enter a valid first name':'');
 set('#e2',v('#st')?'':'Select your state');
 set('#e3',/^\d{10}$/.test(v('#ph'))?'':'Phone must be exactly 10 digits');
 set('#e4',/^[^\s@]+@gmail\.com$/i.test(v('#em'))?'':'Use a valid Gmail address');
 const m=$('#e5');m.className='err'+(ok?' ok':'');m.textContent=ok?'✓ Registration successful':'';
 if(ok)burst()};
/* exp-9 api sim */
const API=[["POST","/addCust","Record Inserted Successfully"],["GET","/getCust","[ {cid:1,fname:'Asha',...} ]"],["PUT","/updCust","Successfully updated record"],["DELETE","/delCust/{cid}","Record Delete Sucessfully"]];
API.forEach(a=>{const r=document.createElement('div');r.className='api';r.style.cursor='pointer';
 r.innerHTML=`<span class="m ${a[0]}">${a[0]}</span>${a[1]}<i>try ▸</i>`;
 r.onclick=()=>{r.classList.remove('fire');void r.offsetWidth;r.classList.add('fire');$('#log').textContent=`> ${a[0]} ${a[1]}\n< 200 OK\n< ${a[2]}`;morph(5);burst()};
 $('#apis').appendChild(r)});
/* THREE */
const cv=$('#gl'),R=new THREE.WebGLRenderer({canvas:cv,antialias:true,alpha:true});
R.setPixelRatio(Math.min(devicePixelRatio,2));
const S=new THREE.Scene(),C=new THREE.PerspectiveCamera(55,1,.1,100);C.position.z=6;
const mat=new THREE.MeshBasicMaterial({color:0x22d3ee,wireframe:true,transparent:true,opacity:.85});
const core=new THREE.Mesh(EXP[0][5](),mat);
const pts=new THREE.Points(core.geometry,new THREE.PointsMaterial({color:0xffffff,size:.04}));core.add(pts);
const ring=new THREE.Mesh(new THREE.TorusGeometry(2.4,.012,8,120),new THREE.MeshBasicMaterial({color:0xa855f7}));
const ring2=ring.clone();ring2.material=new THREE.MeshBasicMaterial({color:0xf472b6});ring2.scale.setScalar(1.3);
const grp=new THREE.Group();grp.add(core,ring,ring2);S.add(grp);
const N=1400,pa=new Float32Array(N*3);for(let i=0;i<N*3;i++)pa[i]=(Math.random()-.5)*30;
const pg=new THREE.BufferGeometry();pg.setAttribute('position',new THREE.BufferAttribute(pa,3));
const dust=new THREE.Points(pg,new THREE.PointsMaterial({color:0x7dd3fc,size:.035,transparent:true,opacity:.7}));S.add(dust);
let tc=new THREE.Color('#22d3ee'),sc=1,pulse=0;
function morph(i){const e=EXP[i];core.geometry.dispose();core.geometry=e[5]();pts.geometry=core.geometry;tc.set(e[4]);sc=.2;pulse=1;
 document.querySelectorAll('.card').forEach((c,k)=>c.classList.toggle('on',k===i))}
function burst(){pulse=1.6}
let mx=0,my=0;addEventListener('pointermove',e=>{mx=e.clientX/innerWidth-.5;my=e.clientY/innerHeight-.5});
function size(){R.setSize(innerWidth,innerHeight,false);C.aspect=innerWidth/innerHeight;C.updateProjectionMatrix()}
addEventListener('resize',size);size();
const rm=matchMedia('(prefers-reduced-motion:reduce)').matches;
const clock=new THREE.Clock();
(function loop(){requestAnimationFrame(loop);const t=clock.getElapsedTime(),sp=Math.min(scrollY/(document.documentElement.scrollHeight-innerHeight||1),1);
 const k=rm?0:1;
 core.rotation.x=t*.25*k+my;core.rotation.y=t*.35*k+mx*1.5+sp*Math.PI*4;
 sc+=(1+pulse*.25-sc)*.08;pulse*=.94;core.scale.setScalar(sc);
 mat.color.lerp(tc,.08);pts.material.color.copy(mat.color);
 ring.rotation.x=t*.4*k;ring.rotation.y=t*.2*k;ring2.rotation.z=-t*.3*k;ring2.rotation.x=1+t*.1*k;
 grp.position.x=Math.sin(sp*Math.PI*2)*1.6;grp.position.y=-sp*1.2;
 dust.rotation.y=t*.02*k+sp*1.5;dust.rotation.x=sp*.6;
 C.position.x+=(mx*1.2-C.position.x)*.05;C.position.y+=(-my*1.2-C.position.y)*.05;C.lookAt(0,0,0);
 R.render(S,C)})();
</script>
</body>
</html>
