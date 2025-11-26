/** @type {import('./$types').LayoutServerLoad} */
export async function load({ cookies }) {
  const token = cookies.get('token') ?? null;
  const res = await fetch(`http://localhost:8080/user?token=${token}`, {
     headers: {
                        "Access-Control-Allow-Origin": "http://localhost:8080",
                    }
                });
    const item = await res.json();

    return { item };
}
