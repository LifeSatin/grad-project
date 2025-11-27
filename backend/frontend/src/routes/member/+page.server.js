export async function load({ fetch, params, cookies }) {
    const token = cookies.get('token') ?? null;

	const res = await fetch(`http://backend:8080/member?token=${token}`, {
                    headers: {
                        "Access-Control-Allow-Origin": "http://localhost:8080",
                    }
                });
    const item = await res.json();
    console.log(item);

    const comres = await fetch(`http://backend:8080/member/comments?memberId=${item.id}`,  headers: {
              "Access-Control-Allow-Origin": "http://backend:8080",
     })
    console.log("comres");
    console.log(comres);
    const comlist = await comres.json();
    console.log("comlist");
    console.log(comlist);

    return { item, comlist };
}