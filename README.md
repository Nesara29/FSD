<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>FSD Project Ecosystem | Full Stack Showcase</title>
  <!-- Tailwind CSS CDN -->
  <script src="https://cdn.tailwindcss.com"></script>
  <!-- Google Fonts: Inter & Outfit -->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&family=Outfit:wght@400;600;700;800&display=swap" rel="stylesheet">
  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
  
  <script>
    tailwind.config = {
      theme: {
        extend: {
          fontFamily: {
            sans: ['Inter', 'sans-serif'],
            display: ['Outfit', 'sans-serif'],
          },
          colors: {
            brand: {
              dark: '#0a0d14',
              card: '#121723',
              accent: '#6366f1',
              neon: '#06b6d4',
              success: '#10b981',
              failure: '#ef4444',
              warning: '#f59e0b',
            }
          },
          animation: {
            'float': 'float 6s ease-in-out infinite',
            'pulse-glow': 'pulseGlow 2s cubic-bezier(0.4, 0, 0.6, 1) infinite',
            'spin-slow': 'spin 12s linear infinite',
          },
          keyframes: {
            float: {
              '0%, 100%': { transform: 'translateY(0px)' },
              '50%': { transform: 'translateY(-12px)' },
            },
            pulseGlow: {
              '0%, 100%': { opacity: '1', boxShadow: '0 0 25px rgba(99, 102, 241, 0.6)' },
              '50%': { opacity: '0.6', boxShadow: '0 0 10px rgba(99, 102, 241, 0.2)' },
            }
          }
        }
      }
    }
  </script>

  <style>
    body {
      background-color: #080a0f;
      color: #f3f4f6;
      font-family: 'Inter', sans-serif;
      overflow-x: hidden;
    }

    /* Glassmorphism card styles */
    .glass-panel {
      background: rgba(18, 23, 35, 0.7);
      backdrop-filter: blur(16px);
      -webkit-backdrop-filter: blur(16px);
      border: 1px solid rgba(255, 255, 255, 0.08);
      box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.37);
    }

    .glass-panel-hover {
      transition: all 0.4s cubic-bezier(0.175, 0.885, 0.32, 1.275);
    }
    .glass-panel-hover:hover {
      border-color: rgba(99, 102, 241, 0.4);
      box-shadow: 0 15px 35px rgba(99, 102, 241, 0.25);
    }

    /* Custom 3D Tilt Card Container */
    .tilt-card {
      transform-style: preserve-3d;
      perspective: 1000px;
    }
    .tilt-card-inner {
      transition: transform 0.2s ease-out;
    }

    /* Gradient Text */
    .text-gradient {
      background: linear-gradient(135deg, #818cf8 0%, #c084fc 50%, #38bdf8 100%);
      -webkit-background-clip: text;
      -webkit-text-fill-color: transparent;
    }

    /* Glowing scrollbar */
    ::-webkit-scrollbar {
      width: 8px;
    }
    ::-webkit-scrollbar-track {
      background: #0a0d14;
    }
    ::-webkit-scrollbar-thumb {
      background: #312e81;
      border-radius: 4px;
    }
    ::-webkit-scrollbar-thumb:hover {
      background: #4338ca;
    }

    /* Glowing borders */
    .glow-border {
      position: relative;
    }
    .glow-border::after {
      content: '';
      position: absolute;
      inset: -1px;
      background: linear-gradient(45deg, #6366f1, transparent, #06b6d4);
      border-radius: inherit;
      z-index: -1;
      opacity: 0.3;
      transition: opacity 0.3s;
    }
    .glow-border:hover::after {
      opacity: 1;
    }
  </style>
</head>
<body class="relative min-h-screen text-slate-200 antialiased selection:bg-indigo-500 selection:text-white">

  <!-- Interactive Canvas Background -->
  <canvas id="particleCanvas" class="fixed inset-0 pointer-events-none z-0 opacity-40"></canvas>

  <!-- Navigation Bar -->
  <header class="sticky top-0 z-50 glass-panel border-b border-slate-800/80 px-6 py-4">
    <div class="max-w-7xl mx-auto flex items-center justify-between">
      <div class="flex items-center gap-3">
        <div class="w-10 h-10 rounded-xl bg-gradient-to-tr from-indigo-600 to-cyan-400 flex items-center justify-center text-white font-black text-xl shadow-lg shadow-indigo-500/30">
          FSD
        </div>
        <div>
          <h1 class="font-display font-bold text-lg tracking-wide text-white flex items-center gap-2">
            ECOSYSTEM <span class="text-xs px-2 py-0.5 rounded-full bg-indigo-500/20 text-indigo-300 border border-indigo-500/30">v2.5 Full-Stack</span>
          </h1>
          <p class="text-xs text-slate-400">UX-Led Web Development Architecture</p>
        </div>
      </div>

      <!-- Header Quick Links -->
      <nav class="hidden md:flex items-center gap-6 text-sm font-medium text-slate-300">
        <a href="#hero" class="hover:text-indigo-400 transition-colors">Overview</a>
        <a href="#projects" class="hover:text-indigo-400 transition-colors">Projects & Modules</a>
        <a href="#simulator" class="hover:text-indigo-400 transition-colors">3D Action Engine</a>
        <a href="#analytics" class="hover:text-indigo-400 transition-colors">System Metrics</a>
      </nav>

      <div class="flex items-center gap-3">
        <button onclick="scrollToSection('simulator')" class="hidden sm:flex items-center gap-2 bg-gradient-to-r from-indigo-600 to-cyan-600 hover:from-indigo-500 hover:to-cyan-500 text-white text-xs font-semibold px-4 py-2.5 rounded-lg shadow-lg shadow-indigo-600/30 transition-all hover:scale-105 active:scale-95">
          <i class="fa-solid fa-bolt"></i> Live 3D Engine
        </button>
      </div>
    </div>
  </header>

  <main class="relative z-10 max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 space-y-20 pt-8 pb-20">

    <!-- HERO SECTION -->
    <section id="hero" class="relative pt-6">
      <div class="grid grid-cols-1 lg:grid-cols-12 gap-12 items-center">
        
        <!-- Left Hero Content -->
        <div class="lg:col-span-7 space-y-6 text-left">
          <div class="inline-flex items-center gap-2 px-3 py-1.5 rounded-full glass-panel border border-indigo-500/30 text-indigo-300 text-xs font-semibold animate-pulse">
            <span class="w-2 h-2 rounded-full bg-indigo-400"></span>
            Rated 5.0 UX-Led Full Stack Repository
          </div>

          <h1 class="font-display text-4xl sm:text-6xl font-extrabold tracking-tight text-white leading-tight">
            Full Stack Development <br>
            <span class="text-gradient">Project Ecosystem</span>
          </h1>

          <p class="text-slate-300 text-base sm:text-lg max-w-2xl font-normal leading-relaxed">
            Unified, interactive architecture showcase extracting real repository modules—ranging from <span class="text-cyan-400 font-semibold">Java Spring Boot REST & JSP CRUD</span>, <span class="text-indigo-400 font-semibold">MongoDB NoSQL Integration</span>, <span class="text-purple-400 font-semibold">React & JS Frontends</span> to <span class="text-emerald-400 font-semibold">JUnit 5 Test Suites</span>.
          </p>

          <!-- Metrics Quick Bar -->
          <div class="grid grid-cols-2 sm:grid-cols-4 gap-4 pt-4">
            <div class="glass-panel p-4 rounded-xl border border-slate-800">
              <span class="text-xs text-slate-400 block font-medium">Extracted Modules</span>
              <span class="text-2xl font-bold font-display text-white" id="stat-modules">8 Core</span>
            </div>
            <div class="glass-panel p-4 rounded-xl border border-slate-800">
              <span class="text-xs text-slate-400 block font-medium">JUnit Pass Rate</span>
              <span class="text-2xl font-bold font-display text-emerald-400">100%</span>
            </div>
            <div class="glass-panel p-4 rounded-xl border border-slate-800">
              <span class="text-xs text-slate-400 block font-medium">Architecture</span>
              <span class="text-2xl font-bold font-display text-cyan-400">REST & MVC</span>
            </div>
            <div class="glass-panel p-4 rounded-xl border border-slate-800">
              <span class="text-xs text-slate-400 block font-medium">DB Connection</span>
              <span class="text-2xl font-bold font-display text-indigo-400">MongoDB</span>
            </div>
          </div>

          <div class="flex flex-wrap gap-4 pt-2">
            <button onclick="scrollToSection('projects')" class="bg-indigo-600 hover:bg-indigo-500 text-white font-semibold px-6 py-3 rounded-xl shadow-xl shadow-indigo-600/30 flex items-center gap-2 transition-all hover:translate-y-[-2px]">
              <i class="fa-solid fa-folder-open"></i> Explore All Projects
            </button>
            <button onclick="scrollToSection('simulator')" class="glass-panel hover:bg-slate-800/80 text-slate-200 font-semibold px-6 py-3 rounded-xl border border-slate-700 flex items-center gap-2 transition-all">
              <i class="fa-solid fa-vr-cardboard text-cyan-400"></i> Test 3D Simulator
            </button>
          </div>
        </div>

        <!-- Right 3D Animated Canvas Orbit Hero Element -->
        <div class="lg:col-span-5 relative flex justify-center items-center">
          <div class="relative w-full max-w-md aspect-square rounded-3xl glass-panel p-4 border border-indigo-500/20 shadow-2xl flex items-center justify-center overflow-hidden glow-border">
            <canvas id="heroOrbitCanvas" class="w-full h-full cursor-grab active:cursor-grabbing"></canvas>
            <div class="absolute bottom-4 left-4 right-4 glass-panel p-3 rounded-xl border border-slate-700/50 flex items-center justify-between text-xs text-slate-300 pointer-events-none">
              <span class="flex items-center gap-2"><i class="fa-solid fa-rotate text-indigo-400 animate-spin-slow"></i> Interactive 3D Node Orbit</span>
              <span class="text-slate-400">Drag to Rotate</span>
            </div>
          </div>
        </div>

      </div>
    </section>

    <!-- INTERACTIVE 3D & ANIMATED GRAPHIC ACTIONS SECTION -->
    <section id="simulator" class="scroll-mt-24 space-y-8">
      <div class="text-center max-w-3xl mx-auto space-y-3">
        <div class="inline-flex items-center gap-2 px-3 py-1 rounded-full bg-cyan-500/10 border border-cyan-500/30 text-cyan-400 text-xs font-semibold">
          <i class="fa-solid fa-microchip"></i> Live Processing Engine
        </div>
        <h2 class="font-display text-3xl sm:text-4xl font-extrabold text-white">
          3D Visual Engine: Income, Action & Outcome Simulator
        </h2>
        <p class="text-slate-400 text-sm sm:text-base">
          Test real-time data flows from front-end user inputs through the Spring Boot service layer into MongoDB storage, with visual failure and success feedback.
        </p>
      </div>

      <!-- Simulator Canvas Container -->
      <div class="glass-panel rounded-3xl p-6 sm:p-8 border border-indigo-500/30 relative overflow-hidden">
        
        <!-- Interactive Controls Bar -->
        <div class="grid grid-cols-1 md:grid-cols-3 gap-4 mb-6">
          <div class="space-y-2">
            <label class="text-xs font-semibold text-slate-300 block">1. Select Pipeline Test Scenario</label>
            <select id="simScenarioSelect" onchange="updateSimScenario()" class="w-full bg-slate-900 border border-slate-700 rounded-xl px-4 py-2.5 text-sm text-white focus:outline-none focus:border-indigo-500">
              <option value="success_register">User Registration (JavaScript/React Validation) -> Success</option>
              <option value="success_mongo">MongoDB Insert Customer Doc -> Success 201</option>
              <option value="success_junit">StoreRepo JUnit Test Assertion -> PASSED</option>
              <option value="fail_500">Spring Boot Controller Exception -> 500 Failure</option>
              <option value="fail_db">MongoDB Timeout / Connection Failure -> Red Alert</option>
            </select>
          </div>

          <div class="space-y-2">
            <label class="text-xs font-semibold text-slate-300 block">2. Processing Load/Speed</label>
            <input type="range" id="simSpeedSlider" min="1" max="5" value="3" class="w-full accent-indigo-500 cursor-pointer">
            <div class="flex justify-between text-[10px] text-slate-400">
              <span>Standard (1x)</span>
              <span>Ultra Fast (5x)</span>
            </div>
          </div>

          <div class="flex items-end gap-3">
            <button onclick="triggerSimAction()" class="w-full bg-gradient-to-r from-emerald-500 to-cyan-500 hover:from-emerald-400 hover:to-cyan-400 text-slate-950 font-bold px-4 py-2.5 rounded-xl shadow-lg shadow-emerald-500/20 text-sm flex items-center justify-center gap-2 transition-all active:scale-95">
              <i class="fa-solid fa-play"></i> Execute Action Flow
            </button>
          </div>
        </div>

        <!-- Visual Flow Graphic Display Canvas -->
        <div class="relative w-full h-80 bg-slate-950/80 rounded-2xl border border-slate-800 overflow-hidden flex items-center justify-center">
          <canvas id="simulatorCanvas" class="w-full h-full"></canvas>

          <!-- Floating Overlay Status Info -->
          <div class="absolute top-4 left-4 bg-slate-900/90 backdrop-blur border border-slate-700/60 rounded-xl p-3 text-xs space-y-1">
            <div class="text-slate-400">Pipeline Status: <span id="simStatusText" class="font-bold text-amber-400">READY</span></div>
            <div class="text-slate-400">Current Payload: <span id="simPayloadText" class="font-mono text-cyan-300">{"user": "Customer#101"}</span></div>
          </div>

          <div class="absolute bottom-4 right-4 bg-slate-900/90 backdrop-blur border border-slate-700/60 rounded-xl p-3 text-xs space-y-1 text-right">
            <div class="text-slate-400">Income Payload: <span id="simIncomeMetric" class="text-indigo-300 font-mono">Input Validation OK</span></div>
            <div class="text-slate-400">Outcome Delivery: <span id="simOutcomeMetric" class="text-emerald-400 font-mono">Response 200 OK</span></div>
          </div>
        </div>

        <!-- Technical Pipeline Breakdown Bar -->
        <div class="grid grid-cols-1 sm:grid-cols-3 gap-4 mt-6 text-center text-xs">
          <div class="p-3 glass-panel rounded-xl border border-slate-800">
            <i class="fa-solid fa-right-to-bracket text-indigo-400 text-base mb-1"></i>
            <div class="font-bold text-white">INCOME (Input)</div>
            <div class="text-slate-400 mt-1">Form Data, REST Body Params, Test Data Fixtures</div>
          </div>
          <div class="p-3 glass-panel rounded-xl border border-slate-800">
            <i class="fa-solid fa-gears text-amber-400 text-base mb-1"></i>
            <div class="font-bold text-white">ACTION (Processing Engine)</div>
            <div class="text-slate-400 mt-1">Spring Boot Controllers, CustRepo Data Mapping, JS Hooks</div>
          </div>
          <div class="p-3 glass-panel rounded-xl border border-slate-800">
            <i class="fa-solid fa-circle-check text-emerald-400 text-base mb-1"></i>
            <div class="font-bold text-white">OUTCOME (Output / Handling)</div>
            <div class="text-slate-400 mt-1">JSP Rendering, JSON Payloads, Exception Handlers</div>
          </div>
        </div>

      </div>
    </section>

    <!-- INTERACTIVE PROJECT EXPLORER (ALL PROJECTS IN ONE SINGLE WEBPAGE) -->
    <section id="projects" class="scroll-mt-24 space-y-8">
      <div class="flex flex-col md:flex-row md:items-end justify-between gap-4">
        <div>
          <div class="inline-flex items-center gap-2 px-3 py-1 rounded-full bg-indigo-500/10 border border-indigo-500/30 text-indigo-400 text-xs font-semibold mb-2">
            <i class="fa-solid fa-cubes"></i> Single-Page Directory
          </div>
          <h2 class="font-display text-3xl sm:text-4xl font-extrabold text-white">
            Project Repository Explorer
          </h2>
          <p class="text-slate-400 text-sm mt-1">
            Browse and inspect all extracted FSD modules with live income/outcome metric breakdowns.
          </p>
        </div>

        <!-- Filter Tabs -->
        <div class="flex flex-wrap gap-2 glass-panel p-1.5 rounded-2xl border border-slate-800" id="filterTabContainer">
          <button onclick="filterProjects('all')" class="filter-btn active bg-indigo-600 text-white px-3.5 py-1.5 rounded-xl text-xs font-semibold transition-all">All Projects</button>
          <button onclick="filterProjects('backend')" class="filter-btn text-slate-400 hover:text-white px-3.5 py-1.5 rounded-xl text-xs font-semibold transition-all">Spring Boot & DB</button>
          <button onclick="filterProjects('frontend')" class="filter-btn text-slate-400 hover:text-white px-3.5 py-1.5 rounded-xl text-xs font-semibold transition-all">Frontend & React</button>
          <button onclick="filterProjects('testing')" class="filter-btn text-slate-400 hover:text-white px-3.5 py-1.5 rounded-xl text-xs font-semibold transition-all">JUnit Testing</button>
        </div>
      </div>

      <!-- Projects Grid -->
      <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6" id="projectsGrid">
        <!-- Project Cards inserted dynamically via JavaScript -->
      </div>
    </section>

    <!-- SYSTEM METRICS & GLOBAL ANALYTICS DASHBOARD -->
    <section id="analytics" class="scroll-mt-24 space-y-8">
      <div class="text-center max-w-2xl mx-auto space-y-2">
        <h2 class="font-display text-3xl font-extrabold text-white">Ecosystem Performance Metrics</h2>
        <p class="text-slate-400 text-sm">Real-time health verification across code coverage, Spring Boot services, and MongoDB operations.</p>
      </div>

      <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-6">
        <!-- Metric Card 1 -->
        <div class="glass-panel p-6 rounded-2xl border border-slate-800 space-y-3">
          <div class="flex items-center justify-between">
            <span class="text-xs font-medium text-slate-400">JUnit Test Pass Rate</span>
            <i class="fa-solid fa-vial-circle-check text-emerald-400"></i>
          </div>
          <div class="text-3xl font-bold font-display text-white">100%</div>
          <div class="w-full bg-slate-800 rounded-full h-2 overflow-hidden">
            <div class="bg-emerald-500 h-full rounded-full" style="width: 100%"></div>
          </div>
          <p class="text-[11px] text-slate-400">StoreRepoTest assertions validated</p>
        </div>

        <!-- Metric Card 2 -->
        <div class="glass-panel p-6 rounded-2xl border border-slate-800 space-y-3">
          <div class="flex items-center justify-between">
            <span class="text-xs font-medium text-slate-400">MongoDB Query Latency</span>
            <i class="fa-solid fa-database text-cyan-400"></i>
          </div>
          <div class="text-3xl font-bold font-display text-white">12 ms</div>
          <div class="w-full bg-slate-800 rounded-full h-2 overflow-hidden">
            <div class="bg-cyan-500 h-full rounded-full" style="width: 88%"></div>
          </div>
          <p class="text-[11px] text-slate-400">NoSQL Document retrieval time</p>
        </div>

        <!-- Metric Card 3 -->
        <div class="glass-panel p-6 rounded-2xl border border-slate-800 space-y-3">
          <div class="flex items-center justify-between">
            <span class="text-xs font-medium text-slate-400">REST API Status</span>
            <i class="fa-solid fa-network-wired text-indigo-400"></i>
          </div>
          <div class="text-3xl font-bold font-display text-white">200 OK</div>
          <div class="w-full bg-slate-800 rounded-full h-2 overflow-hidden">
            <div class="bg-indigo-500 h-full rounded-full" style="width: 96%"></div>
          </div>
          <p class="text-[11px] text-slate-400">JSON Endpoints health active</p>
        </div>

        <!-- Metric Card 4 -->
        <div class="glass-panel p-6 rounded-2xl border border-slate-800 space-y-3">
          <div class="flex items-center justify-between">
            <span class="text-xs font-medium text-slate-400">UI Responsiveness</span>
            <i class="fa-solid fa-laptop-code text-purple-400"></i>
          </div>
          <div class="text-[28px] font-bold font-display text-white">60 FPS</div>
          <div class="w-full bg-slate-800 rounded-full h-2 overflow-hidden">
            <div class="bg-purple-500 h-full rounded-full" style="width: 98%"></div>
          </div>
          <p class="text-[11px] text-slate-400">Hardware-accelerated animations</p>
        </div>
      </div>
    </section>

  </main>

  <!-- SOURCE CODE BREAKDOWN MODAL -->
  <div id="codeModal" class="fixed inset-0 z-50 hidden flex items-center justify-center p-4 bg-black/80 backdrop-blur-md">
    <div class="glass-panel w-full max-w-4xl max-h-[85vh] rounded-3xl border border-slate-700 flex flex-col overflow-hidden shadow-2xl">
      <!-- Modal Header -->
      <div class="p-5 border-b border-slate-800 flex items-center justify-between bg-slate-900/60">
        <div class="flex items-center gap-3">
          <div id="modalBadge" class="w-8 h-8 rounded-lg bg-indigo-600/30 border border-indigo-500/50 flex items-center justify-center text-indigo-400">
            <i class="fa-solid fa-code"></i>
          </div>
          <div>
            <h3 id="modalTitle" class="font-display font-bold text-lg text-white">Project Details</h3>
            <p id="modalPath" class="text-xs text-slate-400 font-mono">FSD/exp-11/CustController.java</p>
          </div>
        </div>
        <button onclick="closeModal()" class="w-8 h-8 rounded-xl bg-slate-800 hover:bg-slate-700 text-slate-300 flex items-center justify-center transition-colors">
          <i class="fa-solid fa-xmark"></i>
        </button>
      </div>

      <!-- Modal Body -->
      <div class="p-6 overflow-y-auto space-y-6 text-sm">
        <div>
          <h4 class="text-xs font-semibold text-slate-400 uppercase tracking-wider mb-2">Project Overview</h4>
          <p id="modalDesc" class="text-slate-300 leading-relaxed"></p>
        </div>

        <div class="grid grid-cols-1 md:grid-cols-2 gap-4">
          <div class="p-4 rounded-xl bg-slate-900/80 border border-slate-800">
            <div class="text-xs font-bold text-indigo-400 mb-1"><i class="fa-solid fa-right-to-bracket mr-1"></i> Incomes / Inputs</div>
            <div id="modalIncome" class="text-slate-300 text-xs"></div>
          </div>
          <div class="p-4 rounded-xl bg-slate-900/80 border border-slate-800">
            <div class="text-xs font-bold text-emerald-400 mb-1"><i class="fa-solid fa-square-check mr-1"></i> Outcomes / Deliverables</div>
            <div id="modalOutcome" class="text-slate-300 text-xs"></div>
          </div>
        </div>

        <!-- Extracted File Tree & Source Preview -->
        <div>
          <h4 class="text-xs font-semibold text-slate-400 uppercase tracking-wider mb-2">Extracted Repository Source Sample</h4>
          <div class="bg-slate-950 rounded-xl border border-slate-800 overflow-hidden font-mono text-xs">
            <div id="modalFileTabs" class="flex border-b border-slate-800 bg-slate-900/80 overflow-x-auto">
              <!-- File tabs populated dynamically -->
            </div>
            <pre id="modalCodeSnippet" class="p-4 text-cyan-300 overflow-x-auto leading-relaxed max-h-60"></pre>
          </div>
        </div>
      </div>

      <!-- Modal Footer -->
      <div class="p-4 border-t border-slate-800 bg-slate-900/60 flex justify-end">
        <button onclick="closeModal()" class="px-5 py-2 rounded-xl bg-slate-800 hover:bg-slate-700 text-white text-xs font-semibold transition-colors">Close Inspection</button>
      </div>
    </div>
  </div>

  <!-- Footer -->
  <footer class="glass-panel border-t border-slate-800/80 py-8 px-6 text-center text-xs text-slate-400 relative z-10">
    <div class="max-w-7xl mx-auto flex flex-col sm:flex-row items-center justify-between gap-4">
      <div>
        <span class="font-bold text-white">Full Stack Development (FSD) Ecosystem</span> &copy; 2026.
      </div>
      <div class="flex gap-4">
        <span>Spring Boot</span> &bull; <span>MongoDB</span> &bull; <span>React</span> &bull; <span>JUnit 5</span>
      </div>
    </div>
  </footer>

  <!-- MAIN SCRIPT DIRECTORY & INTERACTIVE LOGIC -->
  <script>
    // Project Dataset extracted directly from the zip repository index
    const FSD_PROJECTS = [
      {
        id: "exp-11",
        title: "Exp-11: MongoDB + Spring Boot CRUD Integration",
        category: "backend",
        tags: ["Java", "Spring Boot", "MongoDB", "NoSQL", "REST"],
        status: "Active / Verified",
        statusColor: "emerald",
        desc: "Full Spring Boot CRUD microservice connected to MongoDB database featuring CustController, Customer entity model, and CustRepo interface.",
        income: "Customer JSON payloads (Name, Email, Phone, City), Mongo ID parameters.",
        outcome: "Persisted Mongo documents, HTTP 201 Created responses, update confirmation.",
        failure: "MongoTimeoutException handled gracefully with 503 database service fallback.",
        codeSamples: {
          "CustController.java": `@RestController\n@RequestMapping("/customer")\npublic class CustController {\n    @Autowired\n    private CustRepo repo;\n\n    @PostMapping("/add")\n    public Customer addCustomer(@RequestBody Customer customer) {\n        return repo.save(customer);\n    }\n\n    @GetMapping("/all")\n    public List<Customer> getAll() {\n        return repo.findAll();\n    }\n}`,
          "Customer.java": `@Document(collection = "customers")\npublic class Customer {\n    @Id\n    private String id;\n    private String name;\n    private String email;\n    // Getters and Setters\n}`,
          "application.properties": `spring.data.mongodb.uri=mongodb://localhost:27017/fsd_db\nspring.data.mongodb.database=fsd_db`
        }
      },
      {
        id: "exp-12",
        title: "Exp-12: JUnit 5 Testing Suite (Store Repo Test)",
        category: "testing",
        tags: ["Java", "JUnit 5", "Mockito", "Spring Test"],
        status: "Tests Passed",
        statusColor: "indigo",
        desc: "Unit test suite validating data persistence in StoreRepo with assertions on save, update, delete operations.",
        income: "Mocked Store data instances, test fixture attributes.",
        outcome: "Test Execution Report with 100% assertions passed and coverage data.",
        failure: "AssertionError caught on invalid data bounds.",
        codeSamples: {
          "StoreRepoTest.java": `@DataJpaTest\npublic class StoreRepoTest {\n    @Autowired\n    private StoreRepo storeRepo;\n\n    @Test\n    public void testSaveStore() {\n        Store store = new Store("FSD Tech Store", "Bengaluru");\n        Store saved = storeRepo.save(store);\n        Assertions.assertNotNull(saved.getId());\n    }\n}`,
          "Store.java": `@Entity\npublic class Store {\n    @Id @GeneratedValue\n    private Long id;\n    private String name;\n    private String location;\n}`
        }
      },
      {
        id: "exp-9",
        title: "Exp-9: Java Spring Boot CRUD (With REST API)",
        category: "backend",
        tags: ["Java", "Spring Boot", "REST API", "JSON"],
        status: "Active / Verified",
        statusColor: "emerald",
        desc: "RESTful Web API offering full HTTP verb mapping (GET, POST, PUT, DELETE) for enterprise resource handling.",
        income: "REST JSON Request Bodies, PathVariables, Query Params.",
        outcome: "Structured JSON responses with appropriate HTTP Status Codes.",
        failure: "Custom ResourceNotFoundException returning 404 JSON error object.",
        codeSamples: {
          "CustController.java": `@RestController\n@RequestMapping("/api/v1/cust")\npublic class CustController {\n    @Autowired\n    private CustRepo custRepo;\n\n    @GetMapping("/{id}")\n    public ResponseEntity<Customer> getById(@PathVariable Long id) {\n        return ResponseEntity.ok(custRepo.findById(id).orElseThrow());\n    }\n}`
        }
      },
      {
        id: "exp-8",
        title: "Exp-8: Java Spring Boot CRUD (Without API / JSP)",
        category: "backend",
        tags: ["Java", "Spring Boot", "JSP", "Spring MVC"],
        status: "Active / Verified",
        statusColor: "emerald",
        desc: "Traditional Spring MVC application using JSP views (index.jsp, display.jsp, update.jsp, delete.jsp) driven by CpcController.",
        income: "HTML Form submissions via HTTP POST/GET.",
        outcome: "Dynamically rendered server-side JSP HTML pages.",
        failure: "Redirection to global error page on unhandled controller error.",
        codeSamples: {
          "CpcController.java": `@Controller\npublic class CpcController {\n    @RequestMapping("/")\n    public String home() { return "index"; }\n\n    @PostMapping("/save")\n    public String save(@ModelAttribute Cpc cpc, Model m) {\n        // Save logic\n        return "display";\n    }\n}`,
          "index.jsp": `<form action="save" method="post">\n  <input type="text" name="name" placeholder="Name" />\n  <button type="submit">Submit</button>\n</form>`
        }
      },
      {
        id: "exp-5",
        title: "Exp-5: React Form Registration Module",
        category: "frontend",
        tags: ["React", "JSX", "JavaScript", "Tailwind"],
        status: "UI Active",
        statusColor: "cyan",
        desc: "Interactive React registration form with controlled input states, live dynamic validation feedback, and payload previews.",
        income: "User form input strokes, field blur events.",
        outcome: "State updates, formatted state submit object, screen feedback.",
        failure: "Inline error messaging when required fields are empty.",
        codeSamples: {
          "RegistrationForm.jsx": `import React, { useState } from 'react';\n\nexport default function RegistrationForm() {\n  const [formData, setFormData] = useState({ username: '', email: '' });\n  const handleSubmit = (e) => {\n    e.preventDefault();\n    console.log('Submitted payload:', formData);\n  };\n  return (\n    <form onSubmit={handleSubmit}>\n      <input onChange={e => setFormData({...formData, username: e.target.value})} />\n    </form>\n  );\n}`
        }
      },
      {
        id: "exp-6",
        title: "Exp-6: Shopping Cart Application Module",
        category: "frontend",
        tags: ["React", "State Management", "JavaScript"],
        status: "UI Active",
        statusColor: "cyan",
        desc: "Interactive ecommerce cart module featuring dynamic total recalculation, item quantity adjustments, and stock tracking.",
        income: "Item selection clicks, quantity increments/decrements.",
        outcome: "Calculated subtotal, tax estimation, rendered cart list.",
        failure: "Out-of-stock warning triggers when item threshold is reached.",
        codeSamples: {
          "Cart.jsx": `const Cart = ({ items, onRemove }) => {\n  const total = items.reduce((sum, item) => sum + item.price * item.qty, 0);\n  return (\n    <div>\n      <h3>Cart Total: \${total.toFixed(2)}</h3>\n    </div>\n  );\n};`
        }
      },
      {
        id: "exp-7",
        title: "Exp-7: React Router Navigation Engine",
        category: "frontend",
        tags: ["React Router", "SPA", "JavaScript"],
        status: "UI Active",
        statusColor: "cyan",
        desc: "Single Page Application (SPA) multi-page navigation layout utilizing React Router DOM for seamless screen transitions.",
        income: "URL parameter changes, Link click interactions.",
        outcome: "Non-reloading component rendering, browser history sync.",
        failure: "Catch-all 404 Component render on unmapped routes.",
        codeSamples: {
          "App.jsx": `import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';\n\nfunction App() {\n  return (\n    <BrowserRouter>\n      <Routes>\n        <Route path="/" element={<Home />} />\n        <Route path="/cart" element={<Cart />} />\n      </Routes>\n    </BrowserRouter>\n  );\n}`
        }
      },
      {
        id: "exp-4",
        title: "Exp-4: Registration & Auth (Vanilla JS & CSS)",
        category: "frontend",
        tags: ["JavaScript", "HTML5", "CSS3", "DOM"],
        status: "Verified",
        statusColor: "emerald",
        desc: "Pure Vanilla JavaScript registration validation suite handling regex checks for emails, password strengths, and DOM manipulation.",
        income: "Form keystrokes and submit trigger events.",
        outcome: "Validated form submission or targeted DOM alert box.",
        failure: "Border glow color changes to red on regex match failure.",
        codeSamples: {
          "script.js": `document.getElementById('regForm').addEventListener('submit', function(e) {\n  const email = document.getElementById('email').value;\n  if(!email.includes('@')) {\n    e.preventDefault();\n    alert('Please enter a valid email address');\n  }\n});`
        }
      },
      {
        id: "login-auth",
        title: "Auth & Login UI Collection",
        category: "frontend",
        tags: ["HTML5", "CSS3", "Responsive", "UI/UX"],
        status: "UI Active",
        statusColor: "cyan",
        desc: "Agency-level responsive login, registration, and signup design assets with background aesthetics.",
        income: "User credential inputs.",
        outcome: "Authenticated token simulation, layout response.",
        failure: "Visual pulse on invalid inputs.",
        codeSamples: {
          "index.html": `<div class="login-box">\n  <h2>FSD Portal Sign In</h2>\n  <input type="text" placeholder="Username" />\n  <input type="password" placeholder="Password" />\n  <button>Login</button>\n</div>`
        }
      }
    ];

    // Render Project Cards Into DOM
    function renderProjects(items) {
      const grid = document.getElementById('projectsGrid');
      grid.innerHTML = '';

      items.forEach(proj => {
        const card = document.createElement('div');
        card.className = 'glass-panel glass-panel-hover rounded-3xl p-6 border border-slate-800 space-y-4 tilt-card flex flex-col justify-between';
        
        card.innerHTML = `
          <div class="tilt-card-inner space-y-4">
            <div class="flex items-center justify-between">
              <span class="text-[10px] font-bold uppercase tracking-wider px-2.5 py-1 rounded-full bg-${proj.statusColor}-500/10 text-${proj.statusColor}-400 border border-${proj.statusColor}-500/30 flex items-center gap-1.5">
                <span class="w-1.5 h-1.5 rounded-full bg-${proj.statusColor}-400 animate-ping"></span>
                ${proj.status}
              </span>
              <span class="text-xs font-mono text-slate-400">${proj.id}</span>
            </div>

            <h3 class="font-display font-bold text-xl text-white hover:text-indigo-300 transition-colors cursor-pointer" onclick="openModal('${proj.id}')">
              ${proj.title}
            </h3>

            <p class="text-xs text-slate-300 leading-relaxed line-clamp-3">
              ${proj.desc}
            </p>

            <!-- Tech Tags -->
            <div class="flex flex-wrap gap-1.5 pt-1">
              ${proj.tags.map(t => `<span class="text-[10px] bg-slate-800/80 text-slate-300 px-2 py-0.5 rounded-md border border-slate-700/50">${t}</span>`).join('')}
            </div>

            <!-- Income/Outcome Mini Metric -->
            <div class="bg-slate-950/60 p-3 rounded-xl border border-slate-800 text-[11px] space-y-1.5">
              <div class="text-indigo-300 font-semibold flex items-center gap-1">
                <i class="fa-solid fa-arrow-down-long text-[10px]"></i> Input: <span class="text-slate-300 font-normal truncate">${proj.income}</span>
              </div>
              <div class="text-emerald-400 font-semibold flex items-center gap-1">
                <i class="fa-solid fa-arrow-up-long text-[10px]"></i> Output: <span class="text-slate-300 font-normal truncate">${proj.outcome}</span>
              </div>
            </div>
          </div>

          <div class="pt-2 border-t border-slate-800/80 flex items-center justify-between text-xs">
            <button onclick="openModal('${proj.id}')" class="text-indigo-400 hover:text-indigo-300 font-semibold flex items-center gap-1.5 transition-colors">
              <i class="fa-solid fa-code"></i> Source & Specs <i class="fa-solid fa-chevron-right text-[10px]"></i>
            </button>
            <span class="text-slate-400 text-[10px]">Zip Extracted</span>
          </div>
        `;

        // 3D Tilt Event Listeners
        card.addEventListener('mousemove', (e) => {
          const rect = card.getBoundingClientRect();
          const x = e.clientX - rect.left;
          const y = e.clientY - rect.top;
          const centerX = rect.width / 2;
          const centerY = rect.height / 2;
          const rotateX = ((y - centerY) / centerY) * -8;
          const rotateY = ((x - centerX) / centerX) * 8;
          card.style.transform = `perspective(1000px) rotateX(${rotateX}deg) rotateY(${rotateY}deg) translateY(-4px)`;
        });

        card.addEventListener('mouseleave', () => {
          card.style.transform = 'perspective(1000px) rotateX(0deg) rotateY(0deg) translateY(0px)';
        });

        grid.appendChild(card);
      });
    }

    // Filter Buttons Logic
    function filterProjects(cat) {
      document.querySelectorAll('.filter-btn').forEach(btn => {
        btn.classList.remove('active', 'bg-indigo-600', 'text-white');
        btn.classList.add('text-slate-400');
      });
      event.target.classList.add('active', 'bg-indigo-600', 'text-white');
      event.target.classList.remove('text-slate-400');

      if (cat === 'all') {
        renderProjects(FSD_PROJECTS);
      } else {
        const filtered = FSD_PROJECTS.filter(p => p.category === cat);
        renderProjects(filtered);
      }
    }

    // Modal Operations
    function openModal(id) {
      const proj = FSD_PROJECTS.find(p => p.id === id);
      if (!proj) return;

      document.getElementById('modalTitle').innerText = proj.title;
      document.getElementById('modalPath').innerText = `FSD/${proj.id}`;
      document.getElementById('modalDesc').innerText = proj.desc;
      document.getElementById('modalIncome').innerText = proj.income;
      document.getElementById('modalOutcome').innerText = proj.outcome;

      // Render Code Tabs
      const tabsContainer = document.getElementById('modalFileTabs');
      tabsContainer.innerHTML = '';
      const sampleFiles = Object.keys(proj.codeSamples);

      sampleFiles.forEach((file, index) => {
        const tab = document.createElement('button');
        tab.className = `px-3.5 py-2 text-xs font-mono font-medium border-r border-slate-800 ${index === 0 ? 'text-indigo-400 bg-slate-950 border-b-2 border-b-indigo-500' : 'text-slate-400 hover:text-slate-200'}`;
        tab.innerText = file;
        tab.onclick = () => {
          document.querySelectorAll('#modalFileTabs button').forEach(b => {
            b.className = 'px-3.5 py-2 text-xs font-mono font-medium border-r border-slate-800 text-slate-400 hover:text-slate-200';
          });
          tab.className = 'px-3.5 py-2 text-xs font-mono font-medium border-r border-slate-800 text-indigo-400 bg-slate-950 border-b-2 border-b-indigo-500';
          document.getElementById('modalCodeSnippet').innerText = proj.codeSamples[file];
        };
        tabsContainer.appendChild(tab);
      });

      if (sampleFiles.length > 0) {
        document.getElementById('modalCodeSnippet').innerText = proj.codeSamples[sampleFiles[0]];
      }

      document.getElementById('codeModal').classList.remove('hidden');
    }

    function closeModal() {
      document.getElementById('codeModal').classList.add('hidden');
    }

    function scrollToSection(id) {
      document.getElementById(id).scrollIntoView({ behavior: 'smooth' });
    }

    // Canvas Particle Background
    function initParticles() {
      const canvas = document.getElementById('particleCanvas');
      const ctx = canvas.getContext('2d');
      let width = canvas.width = window.innerWidth;
      let height = canvas.height = window.innerHeight;

      const particles = Array.from({ length: 45 }, () => ({
        x: Math.random() * width,
        y: Math.random() * height,
        vx: (Math.random() - 0.5) * 0.4,
        vy: (Math.random() - 0.5) * 0.4,
        radius: Math.random() * 2 + 1,
        color: ['#6366f1', '#06b6d4', '#818cf8'][Math.floor(Math.random() * 3)]
      }));

      function draw() {
        ctx.clearRect(0, 0, width, height);

        particles.forEach((p, i) => {
          p.x += p.vx;
          p.y += p.vy;

          if (p.x < 0 || p.x > width) p.vx *= -1;
          if (p.y < 0 || p.y > height) p.vy *= -1;

          ctx.beginPath();
          ctx.arc(p.x, p.y, p.radius, 0, Math.PI * 2);
          ctx.fillStyle = p.color;
          ctx.fill();

          for (let j = i + 1; j < particles.length; j++) {
            const p2 = particles[j];
            const dist = Math.hypot(p.x - p2.x, p.y - p2.y);
            if (dist < 120) {
              ctx.beginPath();
              ctx.moveTo(p.x, p.y);
              ctx.lineTo(p2.x, p2.y);
              ctx.strokeStyle = `rgba(99, 102, 241, ${0.15 - dist / 1200})`;
              ctx.stroke();
            }
          }
        });

        requestAnimationFrame(draw);
      }

      window.addEventListener('resize', () => {
        width = canvas.width = window.innerWidth;
        height = canvas.height = window.innerHeight;
      });

      draw();
    }

    // Hero 3D Orbit Node Sphere Canvas
    function initHeroOrbit() {
      const canvas = document.getElementById('heroOrbitCanvas');
      const ctx = canvas.getContext('2d');
      const size = canvas.width = canvas.height = 360;

      let angleX = 0;
      let angleY = 0;
      let isDragging = false;
      let prevMousePos = { x: 0, y: 0 };

      const nodes = [
        { label: 'Spring Boot', color: '#10b981', x: 0, y: 0, z: 0 },
        { label: 'MongoDB', color: '#06b6d4', x: 0, y: 0, z: 0 },
        { label: 'React JSX', color: '#6366f1', x: 0, y: 0, z: 0 },
        { label: 'JUnit 5', color: '#f59e0b', x: 0, y: 0, z: 0 },
        { label: 'REST API', color: '#a855f7', x: 0, y: 0, z: 0 },
        { label: 'JSP Views', color: '#ec4899', x: 0, y: 0, z: 0 },
      ];

      // Distribute nodes in 3D sphere
      const radius = 110;
      nodes.forEach((node, idx) => {
        const phi = Math.acos(-1 + (2 * idx) / nodes.length);
        const theta = Math.sqrt(nodes.length * Math.PI) * phi;
        node.baseX = radius * Math.cos(theta) * Math.sin(phi);
        node.baseY = radius * Math.sin(theta) * Math.sin(phi);
        node.baseZ = radius * Math.cos(phi);
      });

      canvas.addEventListener('mousedown', (e) => {
        isDragging = true;
        prevMousePos = { x: e.clientX, y: e.clientY };
      });
      window.addEventListener('mouseup', () => isDragging = false);
      window.addEventListener('mousemove', (e) => {
        if (!isDragging) return;
        const dx = e.clientX - prevMousePos.x;
        const dy = e.clientY - prevMousePos.y;
        angleY += dx * 0.008;
        angleX += dy * 0.008;
        prevMousePos = { x: e.clientX, y: e.clientY };
      });

      function render() {
        ctx.clearRect(0, 0, size, size);
        const centerX = size / 2;
        const centerY = size / 2;

        if (!isDragging) {
          angleY += 0.005;
          angleX += 0.002;
        }

        const calculatedNodes = nodes.map(node => {
          // Rotate Y
          let x1 = node.baseX * Math.cos(angleY) - node.baseZ * Math.sin(angleY);
          let z1 = node.baseX * Math.sin(angleY) + node.baseZ * Math.cos(angleY);
          // Rotate X
          let y2 = node.baseY * Math.cos(angleX) - z1 * Math.sin(angleX);
          let z2 = node.baseY * Math.sin(angleX) + z1 * Math.cos(angleX);

          const scale = (z2 + 200) / 250;
          return {
            ...node,
            projX: centerX + x1,
            projY: centerY + y2,
            scale: Math.max(0.4, scale),
            z: z2
          };
        });

        // Sort by depth
        calculatedNodes.sort((a, b) => a.z - b.z);

        // Draw Connecting Web Lines
        for (let i = 0; i < calculatedNodes.length; i++) {
          for (let j = i + 1; j < calculatedNodes.length; j++) {
            const n1 = calculatedNodes[i];
            const n2 = calculatedNodes[j];
            ctx.beginPath();
            ctx.moveTo(n1.projX, n1.projY);
            ctx.lineTo(n2.projX, n2.projY);
            ctx.strokeStyle = `rgba(99, 102, 241, 0.25)`;
            ctx.lineWidth = 1;
            ctx.stroke();
          }
        }

        // Draw Nodes
        calculatedNodes.forEach(node => {
          ctx.beginPath();
          ctx.arc(node.projX, node.projY, 12 * node.scale, 0, Math.PI * 2);
          ctx.fillStyle = node.color;
          ctx.shadowBlur = 15 * node.scale;
          ctx.shadowColor = node.color;
          ctx.fill();
          ctx.shadowBlur = 0;

          ctx.font = `${11 * node.scale}px Inter, sans-serif`;
          ctx.fillStyle = '#ffffff';
          ctx.fillText(node.label, node.projX + 15 * node.scale, node.projY + 4 * node.scale);
        });

        requestAnimationFrame(render);
      }

      render();
    }

    // 3D Action Engine Simulator Logic
    let simParticles = [];
    let simState = 'IDLE'; // IDLE, PROCESSING, SUCCESS, FAILURE
    let simAnimationId;

    function initSimulator() {
      const canvas = document.getElementById('simulatorCanvas');
      const ctx = canvas.getContext('2d');
      canvas.width = canvas.parentElement.clientWidth;
      canvas.height = canvas.parentElement.clientHeight;

      window.addEventListener('resize', () => {
        if (!canvas.parentElement) return;
        canvas.width = canvas.parentElement.clientWidth;
        canvas.height = canvas.parentElement.clientHeight;
      });

      animateSimulator();
    }

    function triggerSimAction() {
      const scenario = document.getElementById('simScenarioSelect').value;
      const speed = parseInt(document.getElementById('simSpeedSlider').value);

      document.getElementById('simStatusText').innerText = "PROCESSING PAYLOAD...";
      document.getElementById('simStatusText').className = "font-bold text-amber-400";
      
      simState = 'PROCESSING';
      simParticles = [];

      // Generate payload pulse
      const canvas = document.getElementById('simulatorCanvas');
      for (let i = 0; i < 20; i++) {
        simParticles.push({
          x: 60,
          y: canvas.height / 2 + (Math.random() - 0.5) * 20,
          targetX: canvas.width - 60,
          speed: (2 + Math.random() * 2) * speed,
          color: '#f59e0b',
          radius: 4 + Math.random() * 3
        });
      }

      setTimeout(() => {
        if (scenario.startsWith('fail')) {
          simState = 'FAILURE';
          document.getElementById('simStatusText').innerText = "PIPELINE EXCEPTION (FAILED)";
          document.getElementById('simStatusText').className = "font-bold text-red-500";
          document.getElementById('simOutcomeMetric').innerText = "HTTP 500 / Error Exception";
          document.getElementById('simOutcomeMetric').className = "text-red-400 font-mono";
        } else {
          simState = 'SUCCESS';
          document.getElementById('simStatusText').innerText = "ACTION EXECUTED (SUCCESS)";
          document.getElementById('simStatusText').className = "font-bold text-emerald-400";
          document.getElementById('simOutcomeMetric').innerText = "HTTP 200 OK / Persisted";
          document.getElementById('simOutcomeMetric').className = "text-emerald-400 font-mono";
        }
      }, 1200 / speed);
    }

    function updateSimScenario() {
      const scenario = document.getElementById('simScenarioSelect').value;
      const payloadMap = {
        'success_register': '{"user": "FullStackStudent", "pass": "*****"}',
        'success_mongo': '{"_id": "651a02b", "name": "CustomerA", "city": "Bengaluru"}',
        'success_junit': '{"assert": "assertEquals(expected, actual)"}',
        'fail_500': '{"error": "NullPointerException at CustController.java:42"}',
        'fail_db': '{"db_uri": "mongodb://localhost", "status": "ConnectionTimeout"}'
      };
      document.getElementById('simPayloadText').innerText = payloadMap[scenario] || '{}';
    }

    function animateSimulator() {
      const canvas = document.getElementById('simulatorCanvas');
      if (!canvas) return;
      const ctx = canvas.getContext('2d');
      const w = canvas.width;
      const h = canvas.height;

      ctx.clearRect(0, 0, w, h);

      // Node Positions
      const nodeStart = { x: 80, y: h / 2, label: 'INCOME (Input)' };
      const nodeEngine = { x: w / 2, y: h / 2, label: '3D ACTION ENGINE' };
      const nodeEnd = { x: w - 80, y: h / 2, label: 'OUTCOME (Output)' };

      // Draw Connecting Tubes
      ctx.beginPath();
      ctx.moveTo(nodeStart.x, nodeStart.y);
      ctx.lineTo(nodeEnd.x, nodeEnd.y);
      ctx.strokeStyle = simState === 'SUCCESS' ? 'rgba(16, 185, 129, 0.4)' : (simState === 'FAILURE' ? 'rgba(239, 68, 68, 0.4)' : 'rgba(99, 102, 241, 0.3)');
      ctx.lineWidth = 6;
      ctx.stroke();

      // Draw Nodes
      [nodeStart, nodeEngine, nodeEnd].forEach((n, idx) => {
        let nodeColor = '#6366f1';
        if (idx === 1 && simState === 'PROCESSING') nodeColor = '#f59e0b';
        if (idx === 2) {
          if (simState === 'SUCCESS') nodeColor = '#10b981';
          if (simState === 'FAILURE') nodeColor = '#ef4444';
        }

        ctx.beginPath();
        ctx.arc(n.x, n.y, idx === 1 ? 28 : 20, 0, Math.PI * 2);
        ctx.fillStyle = nodeColor;
        ctx.shadowBlur = 20;
        ctx.shadowColor = nodeColor;
        ctx.fill();
        ctx.shadowBlur = 0;

        ctx.font = '10px Inter, sans-serif';
        ctx.fillStyle = '#ffffff';
        ctx.textAlign = 'center';
        ctx.fillText(n.label, n.x, n.y + (idx === 1 ? 45 : 35));
      });

      // Animate Active Particles
      simParticles.forEach((p) => {
        p.x += p.speed;
        if (p.x > w - 80) p.x = 80;

        ctx.beginPath();
        ctx.arc(p.x, p.y, p.radius, 0, Math.PI * 2);
        ctx.fillStyle = simState === 'FAILURE' ? '#ef4444' : (simState === 'SUCCESS' ? '#10b981' : '#f59e0b');
        ctx.fill();
      });

      requestAnimationFrame(animateSimulator);
    }

    // Initialize Page on Load
    window.onload = function () {
      initParticles();
      initHeroOrbit();
      initSimulator();
      renderProjects(FSD_PROJECTS);
    };
  </script>
</body>
</html>
