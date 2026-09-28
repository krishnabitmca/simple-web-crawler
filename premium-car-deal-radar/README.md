# Premium Car Deal Radar

India-wide premium used/demo car deal research dashboard.

Constraints:
- Price <= ₹40 lakh
- Vehicle age <= 4 years
- Prefer low mileage, first owner, certified/demo inventory
- Exclude stale/sold/duplicate or inconsistent listings

## Dashboard
Open `index.html` through Vercel. It reads `data/latest.json`.

## Architecture
The production crawler is intended to run separately through GitHub Actions using Crawl4AI/Playwright. The dashboard is static and deployable on Vercel.

Current branch: premium-car-deal-radar
