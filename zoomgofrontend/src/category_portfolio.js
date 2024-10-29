import "./css/portfolio/portfolio_category.css";
import Header from "./header";
function CategoryPortfolio() {
  const categoryList = ["가", "나", "다", "라", "마", "바"];
  const areaList = [
    "광주",
    "부산",
    "서울",
    "대전",
    "전북",
    "전남",
    "충북",
    "충남",
    "강원도",
    "경기도",
    "인천",
  ];

  const gosus = [
    {
      name: "김철민",
      pic: "사진",
    },
  ];

  const gosuList = [];
  for (let i = 0; i < 12; i++) {
    gosuList.push(...gosus);
  }

  // 4개씩 묶기
  const groupedGosuList = [];
  for (let i = 0; i < gosuList.length; i += 4) {
    groupedGosuList.push(gosuList.slice(i, i + 4));
  }

  return (
    <div className="App">
      <Header />
      <div className="portfolio_category_section">
        <h2>포트폴리오</h2>
        <div style={{ display: "flex", marginTop: "20px" }}>
          <select className="category_select">
            {categoryList.map((category) => (
              <option>{category}</option>
            ))}
          </select>
          <select>
            {areaList.map((area) => (
              <option>{area}</option>
            ))}
          </select>
        </div>
        <div className="line2"></div>
        <div>
          <div className="pictures">
            {groupedGosuList.map((group, index) => (
              <div
                key={index}
                style={{ display: "flex", marginBottom: "20px" }}
              >
                {group.map((gosu, idx) => (
                  <div key={idx} style={{ marginRight: "20px" }}>
                    <div className="picture_box">
                      <span>{gosu.pic}</span>
                    </div>
                    <label htmlFor="name">{gosu.name}</label>
                  </div>
                ))}
              </div>
            ))}
          </div>
        </div>
      </div>
    </div>
  );
}

export default CategoryPortfolio;
