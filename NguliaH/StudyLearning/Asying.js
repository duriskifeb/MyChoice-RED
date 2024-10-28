// Fungsi pisang yang mengembalikan pesan
function pisang() {
  return new Promise((resolve) => {
    setTimeout(() => resolve("Pisang berkata: Saya kaya potasium! 🍌"), 1000);
  });
}

// Fungsi kelapa yang mengembalikan pesan
function kelapa() {
  return new Promise((resolve) => {
    setTimeout(() => resolve("Kelapa berkata: Saya menyegarkan! 🥥"), 1000);
  });
}

// Fungsi melon yang mengembalikan pesan
function melon() {
  return new Promise((resolve) => {
    setTimeout(() => resolve("Melon berkata: Saya manis dan berair! 🍈"), 1000);
  });
}

async function doChoses() {
  const pisangBerkata = await pisang();
  console.log(pisangBerkata);

  const kelapaBerkata = await kelapa();
  console.log(kelapaBerkata);

  const melonBerkata = await melon();
  console.log(melonBerkata);

  console.log("Selesai! #️⃣#️⃣#️⃣#️⃣");
}

doChoses();
